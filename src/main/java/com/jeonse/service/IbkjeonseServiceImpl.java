package com.jeonse.service;

import com.jeonse.dto.IbkjeonseDTO;
import com.jeonse.repository.IbkjeonseMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IbkjeonseServiceImpl implements IbkjeonseService{

    @Autowired
    IbkjeonseMapper ibkjeonseMapper;

    @Override
    public int insertIbkjeonse(@NotNull IbkjeonseDTO list){
        IbkjeonseDTO ibkjeonseDTO=new IbkjeonseDTO();
        ibkjeonseDTO.setMemID(list.getMemID());
        ibkjeonseDTO.setJeonip(list.isJeonip());
        ibkjeonseDTO.setConfirmDate(list.isConfirmDate());
        ibkjeonseDTO.setInterestRate(list.getInterestRate());
        ibkjeonseDTO.setNowJeonse(list.isNowJeonse());
        ibkjeonseDTO.setCreditManagement(list.isCreditManagement());
        ibkjeonseDTO.setLandLordPermit(list.isLandLordPermit());
        ibkjeonseDTO.setChecklistID(list.getChecklistID());
        ibkjeonseMapper.insertIbkjeonse(ibkjeonseDTO);
        return 1;
    }
    @Override
    public IbkjeonseDTO getIbkjeonseDTO(String memID){
        IbkjeonseDTO ibkjeonseDTO=ibkjeonseMapper.getIbkjeonseDTO(memID);
        return ibkjeonseDTO;
    }
    @Override
    public int deleteIbkjeonse(String memID){
        ibkjeonseMapper.deleteIbkjeonse(memID);
        return 0;
    }
}
