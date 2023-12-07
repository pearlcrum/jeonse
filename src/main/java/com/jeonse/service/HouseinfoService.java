package com.jeonse.service;

import com.jeonse.dto.HouseinfoDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface HouseinfoService {
    HouseinfoDTO getHouseinfo(int houseID);

    List<Map<String, Object>> autocomplete(Map<String, Object> paramMap) throws Exception;
}
