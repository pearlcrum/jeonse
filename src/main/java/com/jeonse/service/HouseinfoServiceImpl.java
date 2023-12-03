package com.jeonse.service;

import com.jeonse.dto.HouseinfoDTO;
import com.jeonse.repository.HouseinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class HouseinfoServiceImpl implements HouseinfoService {
    @Autowired
    HouseinfoMapper houseinfoMapper;

    @Override
    public HouseinfoDTO getHouseinfo(int houseID) {
        return houseinfoMapper.getHouseInfo(houseID);
    }

    /*@Override
    public HashMap<Integer, HouseinfoDTO> getHouseInfoByName(String aptName) {
        return houseinfoMapper.getHouseInfoByName(aptName);
    }*/

    @Override
    public HouseinfoDTO getHouseInfoByName(String aptName) {
        return houseinfoMapper.getHouseInfoByName(aptName);
    }

    @Override
    public HashMap<Integer, HouseinfoDTO> getHouseInfoByDong(String dong) {
        return houseinfoMapper.getHouseInfoByDong(dong);
    }
}
