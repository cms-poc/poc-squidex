package com.example.cms.poc.squidex.domain.repositories;

import com.example.cms.poc.squidex.domain.*;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "content", configuration = FeignConfiguration.class)
public interface ContentRepository {
    @PostMapping(path = "/identity-server/connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Headers("Content-Type: application/x-www-form-urlencoded")
    ClientToken token(Map<String, ?> clientGrant);
//
//    @GetMapping("/api/content/myapp/myschema")
//    Collections collections(@RequestHeader("Authorization") String bearerToken);
//
//    @PostMapping("/api/content/myapp/myschema")
//    void addCollection(@RequestBody Collection collection, @RequestHeader("Authorization") String bearerToken);
//
//    @GetMapping("/api/content/myapp/myschema")
//    Items items(@PathVariable("collection") String collection, @RequestHeader("Authorization") String bearerToken);
//
//    @PostMapping("/api/content/myapp/myschema")
//    void addItem(@PathVariable("collection") String collection, @RequestBody Item item, @RequestHeader("Authorization") String bearerToken);
}
