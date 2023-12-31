package com.gaspar.room.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "rooms")
@Data
public class RoomConfiguration {
    private String msg;
    private String buildVersion;
    private Map<String,String> mailDetails;
}
