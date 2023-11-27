package com.jeonse.service;

import com.jeonse.dto.HouseinfoDTO;
import org.springframework.stereotype.Service;

@Service
public interface HouseinfoService {
    HouseinfoDTO getHouseinfo(int houseID);
}
