package cl.neoris.pruebatecnica.util;

import cl.neoris.pruebatecnica.Dummies;
import cl.neoris.pruebatecnica.dto.CreateUserRequest;
import cl.neoris.pruebatecnica.dto.PhoneDTO;
import cl.neoris.pruebatecnica.exception.HTTPException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationUtilTest {

    private static final Pattern passwordPattern = Pattern.compile("^[a-zA-Z]{3,10}$");

    @Test
    void validateCreateUserRequest_OK() throws HTTPException {
        CreateUserRequest request = Dummies.buildCreateUserRequestDummy();
        ValidationUtil.validateCreateUserRequest(request, passwordPattern);
    }

    @Test
    void validateCreateUserRequest_noName() {
        CreateUserRequest request = Dummies.buildCreateUserRequestDummy();
        request.setName(null);
        HTTPException exception = Assertions.assertThrows(HTTPException.class, () -> {
            ValidationUtil.validateCreateUserRequest(request, passwordPattern);
        });
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }

    @Test
    void validateCreateUserRequest_noEmail() {
        CreateUserRequest request = Dummies.buildCreateUserRequestDummy();
        request.setEmail(null);
        HTTPException exception = Assertions.assertThrows(HTTPException.class, () -> {
            ValidationUtil.validateCreateUserRequest(request, passwordPattern);
        });
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }

    @Test
    void validateCreateUserRequest_noPassword() {
        CreateUserRequest request = Dummies.buildCreateUserRequestDummy();
        request.setPassword(null);
        HTTPException exception = Assertions.assertThrows(HTTPException.class, () -> {
            ValidationUtil.validateCreateUserRequest(request, passwordPattern);
        });
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }

    @Test
    void validateCreateUserRequest_noPasswordPatternMatch() {
        CreateUserRequest request = Dummies.buildCreateUserRequestDummy();
        request.setPassword("123456");
        HTTPException exception = Assertions.assertThrows(HTTPException.class, () -> {
            ValidationUtil.validateCreateUserRequest(request, passwordPattern);
        });
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }

    @Test
    void validateCreateUserRequest_noPhones() throws HTTPException {
        CreateUserRequest request = Dummies.buildCreateUserRequestDummy();
        request.setPhones(null);
        ValidationUtil.validateCreateUserRequest(request, passwordPattern);

        request.setPhones(new ArrayList<>());
        ValidationUtil.validateCreateUserRequest(request, passwordPattern);
    }

    @Test
    void validateCreateUserRequest_noPhoneNumber() {
        CreateUserRequest request = Dummies.buildCreateUserRequestDummy();
        PhoneDTO phone = Dummies.buildPhoneDTODummy();
        phone.setNumber(null);
        request.setPhones(Collections.singletonList(phone));

        HTTPException exception = Assertions.assertThrows(HTTPException.class, () -> {
            ValidationUtil.validateCreateUserRequest(request, passwordPattern);
        });
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }

    @Test
    void validateCreateUserRequest_badPhoneNumber() {
        CreateUserRequest request = Dummies.buildCreateUserRequestDummy();
        PhoneDTO phone = Dummies.buildPhoneDTODummy();
        phone.setNumber("asdasdasd");
        request.setPhones(Collections.singletonList(phone));

        HTTPException exception = Assertions.assertThrows(HTTPException.class, () -> {
            ValidationUtil.validateCreateUserRequest(request, passwordPattern);
        });
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }

    @Test
    void validateCreateUserRequest_noCityCode() {
        CreateUserRequest request = Dummies.buildCreateUserRequestDummy();
        PhoneDTO phone = Dummies.buildPhoneDTODummy();
        phone.setCitycode(null);
        request.setPhones(Collections.singletonList(phone));

        HTTPException exception = Assertions.assertThrows(HTTPException.class, () -> {
            ValidationUtil.validateCreateUserRequest(request, passwordPattern);
        });
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }

    @Test
    void validateCreateUserRequest_badCityCode() {
        CreateUserRequest request = Dummies.buildCreateUserRequestDummy();
        PhoneDTO phone = Dummies.buildPhoneDTODummy();
        phone.setCitycode("asdasdasd");
        request.setPhones(Collections.singletonList(phone));

        HTTPException exception = Assertions.assertThrows(HTTPException.class, () -> {
            ValidationUtil.validateCreateUserRequest(request, passwordPattern);
        });
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }

    @Test
    void validateCreateUserRequest_noContryCode() {
        CreateUserRequest request = Dummies.buildCreateUserRequestDummy();
        PhoneDTO phone = Dummies.buildPhoneDTODummy();
        phone.setContrycode(null);
        request.setPhones(Collections.singletonList(phone));

        HTTPException exception = Assertions.assertThrows(HTTPException.class, () -> {
            ValidationUtil.validateCreateUserRequest(request, passwordPattern);
        });
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }

    @Test
    void validateCreateUserRequest_badContryCode() {
        CreateUserRequest request = Dummies.buildCreateUserRequestDummy();
        PhoneDTO phone = Dummies.buildPhoneDTODummy();
        phone.setContrycode("asdasdasd");
        request.setPhones(Collections.singletonList(phone));

        HTTPException exception = Assertions.assertThrows(HTTPException.class, () -> {
            ValidationUtil.validateCreateUserRequest(request, passwordPattern);
        });
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }

}
