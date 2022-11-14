package com.cydeo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Balance extends BaseEntity {

    private BigDecimal amount;
    @OneToOne
    private Customer customer;

    @Override
    public String toString() {
        return "Balance{" +
                "amount=" + amount +
                ", customer=" + customer +
                '}';
    }

}
