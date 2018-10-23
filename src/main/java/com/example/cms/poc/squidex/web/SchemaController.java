package com.example.cms.poc.squidex.web;

import com.example.cms.poc.squidex.domain.FormItem;
import com.example.cms.poc.squidex.domain.Item;
import com.example.cms.poc.squidex.domain.ItemData;
import com.example.cms.poc.squidex.domain.repositories.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        return contentRepository.items(schema, tokenHolder.getAccessToken()).getItems();
    }

    @GetMapping("/{schema}/items")
    public String items() {
        return "schema";
    }

    @PostMapping("/{schema}/items")
    public String createItem(@PathVariable("schema") String schema, @ModelAttribute FormItem formItem) {
        if (! tokenHolder.isAuthenticated()) {
            tokenHolder.authenticate();
        }
        contentRepository.addItem(schema, true, formItem.toItemData(), tokenHolder.getAccessToken());
        return String.format("redirect:/%s/items", schema);
    }
}
