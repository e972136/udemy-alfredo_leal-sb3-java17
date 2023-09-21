package com.gaspar.reservation.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "reservations")
@Data
public class ReservationConfig {
    private String msg;
    private String buildVersion;
    private Map<String,String> mailDetails;
}
