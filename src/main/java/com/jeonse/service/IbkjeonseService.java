package com.jeonse.service;

import com.jeonse.dto.IbkjeonseDTO;
import org.springframework.stereotype.Service;

@Service
public interface IbkjeonseService {
    int insertIbkjeonse(IbkjeonseDTO ibkjeonseDTO);

    IbkjeonseDTO getIbkjeonseDTO(String memID);
}
