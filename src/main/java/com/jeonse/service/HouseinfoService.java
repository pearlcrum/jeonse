package com.jeonse.service;

import com.jeonse.dto.HouseinfoDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface HouseinfoService {
    HouseinfoDTO getHouseinfo(int houseID);

    //HashMap<Integer, HouseinfoDTO> getHouseInfoByName(String aptName);
    HouseinfoDTO getHouseInfoByName(String aptName);

    HashMap<Integer, HouseinfoDTO> getHouseInfoByDong(String dong);
}
