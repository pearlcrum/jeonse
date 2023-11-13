package com.jeonse.dto;

import lombok.Getter;

@Getter
public class HouseDealDto {
    private String no;
    private String dong;
    private String aptName;
    private String code;
    private String dealAmount;
    private String buildYear;
    private String dealYear;
    private String dealMonth;
    private String dealDay;
    private String area;
    private String floor;
    private String jibun;
    private String type;
    private String rentMoney;

    public void setNo(String no) {
        this.no = no;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public void setAptName(String aptName) {
        this.aptName = aptName;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDealAmount(String dealAmount) {
        this.dealAmount = dealAmount;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear;
    }

    public void setDealYear(String dealYear) {
        this.dealYear = dealYear;
    }

    public void setDealMonth(String dealMonth) {
        this.dealMonth = dealMonth;
    }

    public void setDealDay(String dealDay) {
        this.dealDay = dealDay;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setJibun(String jibun) {
        this.jibun = jibun;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRentMoney(String rentMoney) {
        this.rentMoney = rentMoney;
    }
}
