package com.jeonse.dto;


import lombok.Data;

@Data
public class IncomeDTO {
    private String memID;
    private int incomeLastYear;
    private int incomeYearBeforeLast;
    private int debt;
}
