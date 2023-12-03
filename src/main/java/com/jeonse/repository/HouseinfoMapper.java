package com.jeonse.repository;

import com.jeonse.dto.HouseinfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface HouseinfoMapper {

    // 매물 정보 조회
    HouseinfoDTO getHouseInfo(int houseID);

    //List<String> searchHouseByName(String aptName);

    //HashMap<Integer, HouseinfoDTO> getHouseInfoByName(String aptName);

    HouseinfoDTO getHouseInfoByName(String aptName);

    HashMap<Integer, HouseinfoDTO> getHouseInfoByDong(String dong);
}
