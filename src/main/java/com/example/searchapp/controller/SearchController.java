package com.example.searchapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class SearchController {

    @GetMapping("/")
    public String showSearchPage() {
        return "search";
    }

    @GetMapping("/search")
    public String redirectToGoogle(@RequestParam("query") String query) {
        if (query == null || query.trim().isEmpty()) {
            return "redirect:https://www.google.com/search?q=";
        }
        try {
            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8.toString()).replace("+", "%20");
            return "redirect:https://www.google.com/search?q=" + encodedQuery;
        } catch (UnsupportedEncodingException e) {
            // This should not happen with UTF-8
            // Log the error and redirect to a generic Google search or an error page
            System.err.println("Error encoding query: " + e.getMessage());
            return "redirect:https://www.google.com/search";
        }
    }
}
