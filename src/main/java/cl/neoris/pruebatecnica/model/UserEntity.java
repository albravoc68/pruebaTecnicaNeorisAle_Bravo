package cl.neoris.pruebatecnica.model;

import cl.neoris.pruebatecnica.dto.PhoneDTO;
import cl.neoris.pruebatecnica.dto.UserDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "USERS")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "CREATION_DATETIME")
    private Date creationDatetime;

    @Column(name = "MODIFIED")
    private Date modifiedDatetime;

    @Column(name = "LAST_LOGIN")
    private Date lastLogin;

    @Column(name = "ISACTIVE")
    private Boolean isActive;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<PhoneEntity> phones;
    
    public UserDTO toDTO(List<PhoneDTO> phones, String token) {
        UserDTO dto = new UserDTO();
        dto.setId(this.id);
        dto.setCreationDatetime(this.creationDatetime);
        dto.setModifiedDatetime(this.modifiedDatetime);
        dto.setLastLogin(this.lastLogin);
        dto.setIsActive(this.isActive);
        dto.setEmail(this.email);
        dto.setName(this.name);
        dto.setPassword(this.password);
        dto.setPhones(phones);
        dto.setToken(token);

        return dto;
    }

}
