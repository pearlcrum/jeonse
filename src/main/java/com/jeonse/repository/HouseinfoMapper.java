package com.jeonse.repository;

import com.jeonse.dto.HouseinfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouseinfoMapper {

    // 매물 정보 조회
    HouseinfoDTO getHouseInfo(int houseID);

}
