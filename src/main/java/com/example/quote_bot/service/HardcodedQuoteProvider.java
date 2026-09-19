package com.example.quote_bot.service;

import org.springframework.stereotype.Service;

@Service
public class HardcodedQuoteProvider implements QuoteProvider {

    @Override
    public String getQuote() {
        return "...The only way to do great work is to love what you do. — Steve Jobs";
    }
}
