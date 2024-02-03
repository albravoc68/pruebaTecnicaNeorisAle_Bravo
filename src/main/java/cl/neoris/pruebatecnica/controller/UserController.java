package cl.neoris.pruebatecnica.controller;

import cl.neoris.pruebatecnica.dto.CreateUserRequest;
import cl.neoris.pruebatecnica.dto.LoginUserRequest;
import cl.neoris.pruebatecnica.dto.TokenResponse;
import cl.neoris.pruebatecnica.dto.UserDTO;
import cl.neoris.pruebatecnica.exception.HTTPException;
import cl.neoris.pruebatecnica.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/create")
    @ResponseBody
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserRequest createRequest) throws HTTPException {
        return new ResponseEntity<>(userService.createUser(createRequest), HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public ResponseEntity<TokenResponse> loginUser(@RequestBody LoginUserRequest loginRequest) throws HTTPException {
        TokenResponse response = userService.login(loginRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/registeredEmails")
    @ResponseBody
    public ResponseEntity<List<String>> getAllRegisteredEmails() {
        return new ResponseEntity<>(userService.getRegisteredEmails(), HttpStatus.OK);
    }

}
