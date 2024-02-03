package cl.neoris.pruebatecnica.dto;

import cl.neoris.pruebatecnica.model.PhoneEntity;
import lombok.Data;

@Data
public class PhoneDTO {

    private String number;
    private String citycode;
    private String contrycode;

    public PhoneEntity toEntity() {
        PhoneEntity entity = new PhoneEntity();
        entity.setPhoneNumber(Integer.parseInt(this.number));
        entity.setCityCode(Integer.parseInt(this.citycode));
        entity.setCountryCode(Integer.parseInt(this.contrycode));

        return entity;
    }

}
