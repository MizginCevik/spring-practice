package com.cydeo.config;

import com.cydeo.Currency;
import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;

@Configuration
public class Config {

    @Bean
    public Currency currency(){
        return new Currency("1111", "mc_coin");
    }
    @Bean
    public Current current(Currency currency){
        return new Current(currency,new BigDecimal(20), UUID.randomUUID());
    }

    @Bean
    public Saving saving(Currency currency){
        return new Saving(currency,new BigDecimal(40), UUID.randomUUID());
    }
}
