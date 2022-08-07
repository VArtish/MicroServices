package com.example.websocketproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CryptoCurrency {
    private String cryptoCurrencyId;
    private String name;
    private double price;
}
