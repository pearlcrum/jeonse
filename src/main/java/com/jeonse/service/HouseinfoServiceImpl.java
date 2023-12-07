package com.jeonse.service;

import com.jeonse.dto.HouseinfoDTO;
import com.jeonse.repository.HouseinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HouseinfoServiceImpl implements HouseinfoService {
    @Autowired
    HouseinfoMapper houseinfoMapper;

    @Override
    public HouseinfoDTO getHouseinfo(int houseID) {
        return houseinfoMapper.getHouseInfo(houseID);
    }

    @Override
    public List<Map<String, Object>> autocomplete(Map<String, Object> paramMap) throws Exception{
        return houseinfoMapper.autocomplete(paramMap);
    }

}
