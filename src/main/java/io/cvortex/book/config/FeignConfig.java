package io.cvortex.book.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("!test")
@Configuration
@EnableFeignClients(basePackages = "io.cvortex.book")
public class FeignConfig {

    @Bean
    public JacksonEncoder createJacksonEncoder() {
        return new JacksonEncoder(createOjectMapper());
    }

    @Bean
    public JacksonDecoder createJacksonDecoder() {
        return new JacksonDecoder(createOjectMapper());
    }

    @Bean
    public Retryer retryer() {
        // default retryer will retry 5 times waiting waiting
        // 100 ms per retry with a 1.5* back off multiplier
        return new Retryer.Default();
    }

    private ObjectMapper createOjectMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }
}
