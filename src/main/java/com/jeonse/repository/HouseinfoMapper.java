package com.jeonse.repository;

import com.jeonse.dto.HouseinfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface HouseinfoMapper {

    // houseID로 매물 정보 조회
    HouseinfoDTO getHouseInfo(int houseID);

    // 매물 자동완성 조회
    List<Map<String, Object>> autocomplete(Map<String, Object> paramMap) throws Exception;
}
