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
        return new Currency("DLR", "Dollar");
    }
    @Bean
    public Current current(Currency currency){
        Current current = new Current();
        current.setAccountId(UUID.randomUUID());
        current.setAmount(new BigDecimal(400));
        current.setCurrency(currency);
        return current;
        //return new Current(currency, new BigDecimal(20), UUID.randomUUID());
    }

    @Bean
    public Saving saving(){ //Currency currency
        Saving saving = new Saving();
        saving.setAccountId(UUID.randomUUID());
        saving.setAmount(new BigDecimal("500"));
        saving.setCurrency(new Currency("DLR", "Dollar"));
        return saving;
        //return new Saving(currency, new BigDecimal(40), UUID.randomUUID());
    }
}
