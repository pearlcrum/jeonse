package com.jeonse.service;

import com.jeonse.dto.HouseinfoDTO;
import com.jeonse.repository.HouseinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseinfoServiceImpl implements HouseinfoService {
    @Autowired
    HouseinfoMapper houseinfoMapper;

    @Override
    public HouseinfoDTO getHouseinfo(int houseID) {
        return null;
    }
}
