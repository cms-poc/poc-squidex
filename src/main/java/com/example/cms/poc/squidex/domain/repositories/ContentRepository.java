package com.example.cms.poc.squidex.domain.repositories;

import com.example.cms.poc.squidex.domain.*;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@FeignClient(name = "content", configuration = FeignConfiguration.class)
public interface ContentRepository {
    @PostMapping(path = "/identity-server/connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Headers("Content-Type: application/x-www-form-urlencoded")
    ClientToken token(Map<String, ?> clientGrant);

    default List<String> schemas() {
        List<String> schemas = new ArrayList<>();
        schemas.add("stuff");
        schemas.add("things");
        return schemas;
    }

    @GetMapping("/api/content/myapp/{schema}")
    Response items(@PathVariable("schema") String schema, @RequestHeader("Authorization") String bearerToken);
}
