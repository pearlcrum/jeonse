package com.jeonse.dto;

import lombok.Data;

@Data
public class HouseinfoDTO {
    private int houseID;
    private String city;
    private String gu;
    private String dong;
    private String aptName;
    private int dealAmount;
    private int buildYear;
    private int dealYear;
    private double area;
    private int floor;
    private double lat;
    private double lng;
}