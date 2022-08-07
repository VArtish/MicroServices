package com.example.websocketproject.controller;

import com.example.websocketproject.model.service.CryptoCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptoCurrencyController {
    private final CryptoCurrencyService currencyService;

    @Autowired
    public CryptoCurrencyController(CryptoCurrencyService currencyService) {
        this.currencyService = currencyService;
    }


}
