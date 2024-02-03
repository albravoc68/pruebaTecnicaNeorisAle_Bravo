package cl.neoris.pruebatecnica.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

@Configuration
public class UserConfig {

    @Value("${user.creation.passwordPatternRE}")
    private String passwordPatternRE;

    public Pattern getPasswordPattern() {
        if (!StringUtils.hasText(passwordPatternRE)) {
            return null;
        }
        return Pattern.compile(this.passwordPatternRE);
    }

}
