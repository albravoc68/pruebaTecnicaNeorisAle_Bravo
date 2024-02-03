package cl.neoris.pruebatecnica.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PHONES")
@Data
public class PhoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PHONES_GENERATOR")
    @SequenceGenerator(name = "PHONES_GENERATOR", sequenceName = "PHONES_SEQ", allocationSize = 1)
    private Integer id;

    @Column(name = "PHONE_NUMBER")
    private Integer phoneNumber;

    @Column(name = "CITYCODE")
    private Integer cityCode;

    @Column(name = "COUNTRYCODE")
    private Integer countryCode;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity user;

}
