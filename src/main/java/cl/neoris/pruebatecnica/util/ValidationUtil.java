package cl.neoris.pruebatecnica.util;

import cl.neoris.pruebatecnica.dto.CreateUserRequest;
import cl.neoris.pruebatecnica.dto.PhoneDTO;
import cl.neoris.pruebatecnica.exception.HTTPException;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

    public static final String RE_EMAIL_VALIDATION = "[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,5}";
    public static final Pattern PATTERN_EMAIL = Pattern.compile(RE_EMAIL_VALIDATION);

    public static void validateCreateUserRequest(CreateUserRequest request, Pattern passwordPattern) throws HTTPException {
        if (!StringUtils.hasText(request.getName())) {
            throw new HTTPException(HttpStatus.BAD_REQUEST, "Campo name no debe ir vacío.");
        }
        if (request.getName().length() > 255) {
            throw new HTTPException(HttpStatus.BAD_REQUEST, "Nombre no debe superar los 255 carácteres.");
        }

        if (!StringUtils.hasText(request.getEmail())) {
            throw new HTTPException(HttpStatus.BAD_REQUEST, "Campo email no debe ir vacío.");
        }
        Matcher emailMatcher = PATTERN_EMAIL.matcher(request.getEmail());
        if (!emailMatcher.find()) {
            throw new HTTPException(HttpStatus.BAD_REQUEST, "Campo email debe tener un formato válido. Ej. aaaaaaa@dominio.cl");
        }
        if (request.getEmail().length() > 255) {
            throw new HTTPException(HttpStatus.BAD_REQUEST, "Email no debe superar los 255 carácteres.");
        }

        if (!StringUtils.hasText(request.getPassword())) {
            throw new HTTPException(HttpStatus.BAD_REQUEST, "Campo password no debe ir vacío.");
        }
        if (passwordPattern != null) {
            Matcher passwordMatcher = passwordPattern.matcher(request.getPassword());
            if (!passwordMatcher.find()) {
                throw new HTTPException(HttpStatus.BAD_REQUEST, "Campo password debe respetar la expresión regular configurada.");
            }
        }
        if (request.getPassword().length() > 255) {
            throw new HTTPException(HttpStatus.BAD_REQUEST, "Password no debe superar los 255 carácteres.");
        }

        if (request.getPhones() == null || request.getPhones().isEmpty()) {
            return;
        }
        for (PhoneDTO phone : request.getPhones()) {
            if (!StringUtils.hasText(phone.getNumber()) || !NumberUtil.isInteger(phone.getNumber())) {
                throw new HTTPException(HttpStatus.BAD_REQUEST, "Campo Number debe ser un número válido.");
            }
            if (phone.getNumber().length() > 20) {
                throw new HTTPException(HttpStatus.BAD_REQUEST, "Campo Number no debe superar los 20 carácteres.");
            }

            if (!StringUtils.hasText(phone.getCitycode()) || !NumberUtil.isInteger(phone.getCitycode())) {
                throw new HTTPException(HttpStatus.BAD_REQUEST, "Campo citycode debe ser un número válido.");
            }
            if (phone.getCitycode().length() > 10) {
                throw new HTTPException(HttpStatus.BAD_REQUEST, "Campo citycode no debe superar los 10 carácteres.");
            }

            if (!StringUtils.hasText(phone.getContrycode()) || !NumberUtil.isInteger(phone.getContrycode())) {
                throw new HTTPException(HttpStatus.BAD_REQUEST, "Campo contrycode debe ser un número válido.");
            }
            if (phone.getContrycode().length() > 20) {
                throw new HTTPException(HttpStatus.BAD_REQUEST, "Campo contrycode no debe superar los 10 carácteres.");
            }
        }
    }

}
