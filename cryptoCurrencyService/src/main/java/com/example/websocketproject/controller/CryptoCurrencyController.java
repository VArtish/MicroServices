package com.example.websocketproject.controller;

import com.example.websocketproject.model.service.CryptoCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CryptoCurrencyController {
    private final CryptoCurrencyService currencyService;

    @Autowired
    public CryptoCurrencyController(CryptoCurrencyService currencyService) {
        this.currencyService = currencyService;
    }


}
