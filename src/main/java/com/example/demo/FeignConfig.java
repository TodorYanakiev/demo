package com.example.demo;

import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMmYyZWJhNDczMGZkZGIzY2UzMTEyNmE5MzllZDM0NiIsInN1YiI6IjY2NjljYTgzMDlhYjg2NWY1YWFhMWRmNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.fJihxq-iy6BLWEJwLH0-kxt74z3YbWBgLNikDgCvCpQ");
        };
    }
    @Bean public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder(); }

}
