package com.example.cms.poc.squidex.web;

import com.example.cms.poc.squidex.domain.Item;
import com.example.cms.poc.squidex.domain.repositories.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CollectionController {
    private final TokenHolder tokenHolder;

    private final ContentRepository contentRepository;

    @ModelAttribute("items")
    public List<Item> items(@PathVariable("collection") String collection) {
        if (! tokenHolder.isAuthenticated()) {
            tokenHolder.authenticate();
        }
        return new ArrayList<>();
//        return contentRepository.items(collection, "admin_token").getData();
    }

    @GetMapping("/{collection}/items")
    public String items() {
        return "collection";
    }

    @PostMapping("/{collection}/items")
    public String createCollection(@PathVariable("collection") String collection, @ModelAttribute("item") Item item) {
        if (! tokenHolder.isAuthenticated()) {
            tokenHolder.authenticate();
        }
//        contentRepository.addItem(collection, item, "admin_token");
        return String.format("redirect:/%s/items", collection);
    }
}
