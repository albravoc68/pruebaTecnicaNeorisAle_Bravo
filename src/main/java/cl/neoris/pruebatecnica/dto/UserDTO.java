package cl.neoris.pruebatecnica.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class UserDTO {

    private UUID id;
    private Date creationDatetime;
    private Date modifiedDatetime;
    private Date lastLogin;
    private String token;
    private Boolean isActive;
    private String name;
    private String email;
    private String password;
    private List<PhoneDTO> phones;

}
