package com.jeonse.service;

import com.jeonse.dto.CommonchecklistDTO;
import com.jeonse.dto.MemberDTO;
import com.jeonse.repository.CommonchecklistMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CommonchecklistServiceImpl implements CommonchecklistService{
    @Autowired
    CommonchecklistMapper commonchecklistMapper;

    @Override
    public int insertCommonchecklist(@NotNull CommonchecklistDTO list){

        //공통 체크리스트에 문제 있을 경우
        // return 0;
        if(list.isAgentCheck()==false){
            return 0;
        }else if(list.isForiengerCheck()==false){
            return 0;
        }else if(list.isFamilyCheck()==false){
            return 0;
        }else if(list.getJeonseTerm()<3 || list.getJeonseTerm()>24){
            return 0;
        }else if(list.getLandlordPossessionMonth()<3){
            return 0;
        }else {
            //공통 체크리스트에 문제 없을 경우
            CommonchecklistDTO commonchecklistDto = new CommonchecklistDTO();
            commonchecklistDto.setMemID(list.getMemID());
            commonchecklistDto.setAgentCheck(list.isAgentCheck());
            commonchecklistDto.setForiengerCheck(list.isForiengerCheck());
            commonchecklistDto.setFamilyCheck(list.isFamilyCheck());
            commonchecklistDto.setLoanAmount(list.getLoanAmount());
            commonchecklistDto.setHousePrice(list.getHousePrice());
            commonchecklistDto.setJeonseDeposit(list.getJeonseDeposit());
            commonchecklistDto.setJeonseTerm(list.getJeonseTerm());
            commonchecklistDto.setLandlordPossessionMonth(list.getLandlordPossessionMonth());
            commonchecklistDto.setSeniorDebt(list.getSeniorDebt());
            commonchecklistMapper.insertCommonchecklist(commonchecklistDto);
            return 1;
        }

    }
    @Override
    public void deleteCommonchecklist(String memID){ //체크리스트 지우기
        if(commonchecklistMapper.checkCommonchecklistID(memID)!=0) {
            commonchecklistMapper.deleteCommonchecklist(memID);
        }
    }
    @Override
    public int checkCommonchecklistID(String memID){ // 값 있는 지 체크
        int cnt = commonchecklistMapper.checkCommonchecklistID(memID);
        System.out.println("serviceImpl >> " + cnt);
        return cnt;
    }
}