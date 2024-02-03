package cl.neoris.pruebatecnica.services;

import cl.neoris.pruebatecnica.dto.CreateUserRequest;
import cl.neoris.pruebatecnica.dto.LoginUserRequest;
import cl.neoris.pruebatecnica.dto.TokenResponse;
import cl.neoris.pruebatecnica.dto.UserDTO;
import cl.neoris.pruebatecnica.exception.HTTPException;

import java.util.List;

public interface UserService {

    UserDTO createUser(CreateUserRequest request) throws HTTPException;

    TokenResponse login(LoginUserRequest request) throws HTTPException;

    List<String> getRegisteredEmails();

}
