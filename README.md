# Quote Bot

A small Spring Boot API that returns a random quote. Built as a learning project to understand what's actually happening under the hood in a Spring Boot app — beans, dependency injection, calling external APIs, and Lombok — rather than just memorizing annotations.

## What it does

`GET /quote` returns a random quote, fetched live from the [DummyJSON](https://dummyjson.com/docs/quotes) quotes API.

```bash
curl http://localhost:8080/quote
```

```json
"Chaos is a friend of mine. — Bob Dylan"
```

## Stack

- Java 25
- Spring Boot 4 (Spring Web / MVC)
- Maven
- Lombok

## Project structure

```
src/main/java/com/example/quote_bot/
├── QuoteBotApplication.java
├── config/
│   └── RestClientConfig.java      # RestClient bean, configured with DummyJSON base URL
├── controller/
│   └── QuoteController.java       # exposes GET /quote
├── dto/
│   └── QuoteResponse.java         # maps the DummyJSON JSON response
└── service/
    ├── QuoteProvider.java         # interface
    ├── ApiQuoteProvider.java      # @Primary — hits the real API
    └── HardcodedQuoteProvider.java # fallback / alternate implementation
```

## Running it

```bash
./mvnw spring-boot:run
```

Then hit `http://localhost:8080/quote`.

## Why two `QuoteProvider` implementations?

This project deliberately has two beans implementing the same interface — `ApiQuoteProvider` (marked `@Primary`, calls the real API) and `HardcodedQuoteProvider` (a static fallback) — as a way to explore how Spring resolves ambiguous dependencies (`@Primary` vs `@Qualifier`), rather than because the app strictly needs both.

## What this project was for

This is Project 1 in a series of Spring Boot learning projects, each built to deeply understand one layer of the framework instead of just shipping a feature:

- Maven fundamentals — dependency resolution, the parent POM, starters
- Beans and the IoC container, component scanning
- Constructor injection and how Spring resolves ambiguous beans (`@Primary`, `@Qualifier`)
- Calling an external API with `RestClient`
- Lombok, decompiled — understanding exactly what `@RequiredArgsConstructor` and `@Slf4j` generate, and where Lombok is and isn't the right tool


