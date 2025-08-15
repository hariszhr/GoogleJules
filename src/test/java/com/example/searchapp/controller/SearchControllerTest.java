package com.example.searchapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SearchController.class)
public class SearchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShowSearchPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.view().name("search"));
    }

    @Test
    public void testRedirectToGoogle() throws Exception {
        String query = "spring boot";
        mockMvc.perform(get("/search").param("query", query))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("https://www.google.com/search?q=spring%20boot"));
    }

    @Test
    public void testRedirectToGoogle_emptyQuery() throws Exception {
        mockMvc.perform(get("/search").param("query", ""))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("https://www.google.com/search?q="));
    }
}
