package com.example.cms.poc.squidex.web;

import com.example.cms.poc.squidex.domain.Collection;
import com.example.cms.poc.squidex.domain.ListedCollection;
import com.example.cms.poc.squidex.domain.repositories.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final TokenHolder tokenHolder;

    private final ContentRepository contentRepository;

    @ModelAttribute("collections")
    public List<ListedCollection> collections() {
        if (! tokenHolder.isAuthenticated()) {
            tokenHolder.authenticate();
        }
        return new ArrayList<>();
//        return contentRepository.collections("admin_token").getData().stream().filter(ListedCollection::isManaged).collect(Collectors.toList());
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/")
    public String createCollection(@ModelAttribute("collection") Collection collection) {
        if (! tokenHolder.isAuthenticated()) {
            tokenHolder.authenticate();
        }
//        contentRepository.addCollection(collection.withPrimaryKey("id").withStringField("name", 100, true, "The project title"), "admin_token");
        return "redirect:/";
    }
}
