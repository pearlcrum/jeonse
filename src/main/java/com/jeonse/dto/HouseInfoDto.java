package com.jeonse.dto;

import lombok.Getter;

@Getter
public class HouseInfoDto {
    @Override
    public String toString() {
        return "HouseInfoDto [no=" + no + ", dong=" + dong + ", aptName=" + aptName + ", code=" + code + ", buildYear="
                + buildYear + ", jibun=" + jibun + ", lat=" + lat + ", lng=" + lng + ", img=" + img + "]";
    }

    private String no;
    private String dong;
    private String aptName;
    private String code;
    private String buildYear;
    private String jibun;
    private String lat;
    private String lng;
    private String img;

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

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear;
    }

    public void setJibun(String jibun) {
        this.jibun = jibun;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
