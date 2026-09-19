package com.example.quote_bot.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.quote_bot.dto.QuoteResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service 
@Primary 
@RequiredArgsConstructor 
@Slf4j 
public class ApiQuoteProvider implements QuoteProvider {

    @Qualifier("quotesClient")
    private final RestClient quotesClient;

    @Override
    public String getQuote() {
        log.info("Fetching a random quote from DummyJSON");

        QuoteResponse response = quotesClient.get()
                .uri("/quotes/random")
                .retrieve()
                .body(QuoteResponse.class);

        log.info("Received quote id={} author={}", response.id(), response.author());
                
        return response.quote() + " — " + response.author();
    }

}
