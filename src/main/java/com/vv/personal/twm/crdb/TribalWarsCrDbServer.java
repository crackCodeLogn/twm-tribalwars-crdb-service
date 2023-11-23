package com.vv.personal.twm.crdb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.ZoneId;
import java.util.TimeZone;

@Slf4j
@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan({"com.vv.personal.twm.crdb", "com.vv.personal.twm.ping"})
@SpringBootApplication
public class TribalWarsCrDbServer {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("EST", ZoneId.SHORT_IDS))); //force setting
        SpringApplication.run(TribalWarsCrDbServer.class, args);
    }

    @Autowired
    private Environment environment;

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    private static final String LOCALHOST = "localhost";
    private static final String LOCAL_SPRING_PORT = "server.port";
    private static final String SWAGGER_UI_URL = "http://%s:%s/swagger-ui/index.html";

    @EventListener(ApplicationReadyEvent.class)
    public void firedUpAllCylinders() {
        String host = LOCALHOST;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.error("Failed to obtain ip address. ", e);
        }
        String port = environment.getProperty(LOCAL_SPRING_PORT);
        log.info("'{}' activation is complete! Exact url: {}", environment.getProperty("spring.application.name").toUpperCase(), String.format(SWAGGER_UI_URL, host, port));
    }
}