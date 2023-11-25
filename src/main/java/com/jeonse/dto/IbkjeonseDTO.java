package com.jeonse.dto;

import lombok.Data;

@Data
public class IbkjeonseDTO {
    private int ibkjeonseID;
    private boolean jeonip;//전입가능 여부
    private boolean confirmDate;//확정일자
    private double interestRate;//금리
    private boolean nowJeonse;//현재 전세대출 보유 여부
    private boolean creditManagement; //신용관리 대상 여부
    private boolean landLordPermit;// 임대인의임차보증금반환채권 승낙 가능 여부
    private int checklistID;
}