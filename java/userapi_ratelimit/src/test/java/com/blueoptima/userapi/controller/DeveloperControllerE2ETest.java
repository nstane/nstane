package com.blueoptima.userapi.controller;

import com.blueoptima.userapi.ratelimit.exception.RateLimitException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.Objects;
import java.util.stream.IntStream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan(basePackages = "com.blueoptima.userapi")
@TestPropertySource(value = "classpath:application.properties")
public class DeveloperControllerE2ETest {
    @Autowired
    protected TestRestTemplate restTemplate;

    private static final String DEVELOPER_API = "/api/v1/developers";

    @Test
    public void testDeveloperAPIRateLimit() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Name", "user1");

        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        IntStream.rangeClosed(1, 5).forEach(
                e-> restTemplate.exchange(DEVELOPER_API, HttpMethod.GET, entity, String.class)
        );

        ResponseEntity<String> errorResponse = restTemplate.exchange(DEVELOPER_API, HttpMethod.GET, entity, String.class);

        Assert.isTrue(Objects.equals(errorResponse.getStatusCode(), HttpStatus.TOO_MANY_REQUESTS), "");
    }
}
