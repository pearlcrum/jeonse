package com.jeonse.dto;

import lombok.Getter;

@Getter
public class SidoGugunCodeDto {
    @Override
    public String toString() {
        return "SidoGugunCodeDto [sidoCode=" + sidoCode + ", sidoName=" + sidoName + ", gugunCode=" + gugunCode
                + ", gugunName=" + gugunName + "]";
    }

    private String sidoCode;
    private String sidoName;
    private String gugunCode;
    private String gugunName;

    public void setSidoCode(String sidoCode) {
        this.sidoCode = sidoCode;
    }

    public void setSidoName(String sidoName) {
        this.sidoName = sidoName;
    }

    public void setGugunCode(String gugunCode) {
        this.gugunCode = gugunCode;
    }

    public void setGugunName(String gugunName) {
        this.gugunName = gugunName;
    }
}
