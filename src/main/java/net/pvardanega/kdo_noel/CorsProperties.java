package net.pvardanega.kdo_noel;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "cors")
class CorsProperties {

    private String origin = "*";

}
