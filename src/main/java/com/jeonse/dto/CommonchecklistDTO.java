package com.jeonse.dto;

import lombok.Data;

@Data
public class CommonchecklistDTO {
    private String memID;
    private boolean agentCheck;
    private boolean foriengerCheck;
    private boolean familyCheck;
    private int loanAmount; //대출 원하는 금액
    private int housePrice; //집 값
    private int jeonseDeposit; //보증금
    private int jeonseTerm; //전세 기간
    private int landlordPossessionMonth;
    private int seniorDebt;
    private int houseID;
}