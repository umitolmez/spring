package com.cydeo.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class CreatedAccount extends Account{

    BigDecimal creditLimit;

}
