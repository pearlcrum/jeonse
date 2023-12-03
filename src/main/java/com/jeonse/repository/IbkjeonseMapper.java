package com.jeonse.repository;

import com.jeonse.dto.IbkjeonseDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IbkjeonseMapper {
    void insertIbkjeonse(IbkjeonseDTO ibkjeonseDTO);

    IbkjeonseDTO getIbkjeonseDTO(String memID);
}
