package com.example.quote_bot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quote_bot.service.QuoteProvider;

@RestController
public class QuoteController {
    
    private final QuoteProvider quoteService;

    public QuoteController(QuoteProvider quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/quote")
    public String getQuote() {
        return quoteService.getQuote();
    }

}
