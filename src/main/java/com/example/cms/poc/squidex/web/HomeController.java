package com.example.cms.poc.squidex.web;

import com.example.cms.poc.squidex.domain.repositories.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ContentRepository contentRepository;

    @ModelAttribute("schemas")
    public List<String> schemas() {
        return contentRepository.schemas();
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
