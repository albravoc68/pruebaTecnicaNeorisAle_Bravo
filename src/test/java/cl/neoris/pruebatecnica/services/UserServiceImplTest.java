package cl.neoris.pruebatecnica.services;

import cl.neoris.pruebatecnica.Dummies;
import cl.neoris.pruebatecnica.config.UserConfig;
import cl.neoris.pruebatecnica.config.security.JWTAuthtenticationConfig;
import cl.neoris.pruebatecnica.dto.CreateUserRequest;
import cl.neoris.pruebatecnica.dto.UserDTO;
import cl.neoris.pruebatecnica.exception.HTTPException;
import cl.neoris.pruebatecnica.repositories.PhoneRepository;
import cl.neoris.pruebatecnica.repositories.UserRepository;
import cl.neoris.pruebatecnica.services.impl.UserServiceImpl;
import cl.neoris.pruebatecnica.util.ValidationUtil;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    private static final String DUMMY_TOKEN = "DUMMY-TOKEN";

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserConfig userConfig;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PhoneRepository phoneRepository;

    @Mock
    private JWTAuthtenticationConfig jwtAuthtentication;

    @BeforeEach
    public void init() {
        Pattern passwordPattern = Pattern.compile("^[a-zA-Z]{3,10}$");
        when(userConfig.getPasswordPattern()).thenReturn(passwordPattern);
    }

    @Test
    void createUser_OK() throws HTTPException {
        when(userRepository.existsByEmail(any())).thenReturn(false);
        when(jwtAuthtentication.getJWTToken(any())).thenReturn(DUMMY_TOKEN);

        CreateUserRequest request = Dummies.buildCreateUserRequestDummy();
        UserDTO result = userService.createUser(request);

        assertNotNull(result);
        assertNotNull(result.getCreationDatetime());
        assertNotNull(result.getModifiedDatetime());
        assertNotNull(result.getLastLogin());
        assertEquals("DUMMY-TOKEN", result.getToken());
        assertTrue(result.getIsActive());
        assertEquals(request.getName(), result.getName());
        assertEquals(request.getEmail(), result.getEmail());
        assertEquals(request.getPassword(), result.getPassword());

        assertNotNull(result.getPhones());
        assertFalse(result.getPhones().isEmpty());
        assertEquals(request.getPhones().get(0).getNumber(), result.getPhones().get(0).getNumber());
        assertEquals(request.getPhones().get(0).getCitycode(), result.getPhones().get(0).getCitycode());
        assertEquals(request.getPhones().get(0).getContrycode(), result.getPhones().get(0).getContrycode());
    }

    @Test
    void createUser_duplicateEmail() {
        when(userRepository.existsByEmail(any())).thenReturn(true);

        CreateUserRequest request = Dummies.buildCreateUserRequestDummy();
        HTTPException exception = Assertions.assertThrows(HTTPException.class, () -> {
            userService.createUser(request);
        });
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }

}
