package com.jeonse.repository;

import com.jeonse.dto.IbkansimjeonseDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IbkansimjeonseMapper {
    //값 넣는 것
    void insertIbkansimjeonse(IbkansimjeonseDTO ibkansimjeonseDTO);

    IbkansimjeonseDTO getIbkansimjeonseDTO(String memID);
    int deleteIbkAnsimjeonse(String memID);

}
