package com.example.cms.poc.squidex.web;

import com.example.cms.poc.squidex.domain.Item;
import com.example.cms.poc.squidex.domain.repositories.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SchemaController {
    private final TokenHolder tokenHolder;

    private final ContentRepository contentRepository;

    @ModelAttribute("items")
    public List<Item> items(@PathVariable("schema") String schema) {
        if (! tokenHolder.isAuthenticated()) {
            tokenHolder.authenticate();
        }
        contentRepository.items(schema, tokenHolder.getAccessToken()).getItems().forEach(System.out::println);
        return contentRepository.items(schema, tokenHolder.getAccessToken()).getItems();
    }

    @GetMapping("/{schema}/items")
    public String items() {
        return "schema";
    }
}
