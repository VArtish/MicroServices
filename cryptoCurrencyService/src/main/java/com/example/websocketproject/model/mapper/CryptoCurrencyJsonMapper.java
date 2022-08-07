package com.example.websocketproject.model.mapper;

import com.example.websocketproject.model.entity.CryptoCurrency;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CryptoCurrencyJsonMapper {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger LOGGER = LogManager.getLogger(CryptoCurrencyJsonMapper.class);
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String QUOTES = "quotes";
    private static final String USD = "USD";
    private static final String PRICE = "price";

    public static List<CryptoCurrency> map(String json) {
        List<CryptoCurrency> currencies = new ArrayList<>();
        try {
            JsonNode tree = mapper.readTree(json);
            Iterator<JsonNode> elements = tree.elements();

            while (elements.hasNext()) {
                CryptoCurrency currency = new CryptoCurrency();
                JsonNode element = elements.next();
                String name = element.get(NAME).asText();
                String id = element.get(ID).asText();
                JsonNode quotes = element.get(QUOTES);
                JsonNode usd = quotes.get(USD);
                Double price = usd.get(PRICE).asDouble();
                currency.setCryptoCurrencyId(id);
                currency.setName(name);
                currency.setPrice(price);
                currencies.add(currency);
            }
        } catch (JsonProcessingException jsonProcessingException) {
            LOGGER.log(Level.ERROR, jsonProcessingException.getMessage());
        }

        return currencies;
    }
}
