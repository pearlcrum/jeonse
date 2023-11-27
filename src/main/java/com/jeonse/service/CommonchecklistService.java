package com.jeonse.service;

import com.jeonse.dto.CommonchecklistDTO;
import org.springframework.stereotype.Service;

@Service
public interface CommonchecklistService {
    // 값 입력
    int insertCommonchecklist(CommonchecklistDTO commonchecklistDto);
    // 값 삭제
    void deleteCommonchecklist(String memID);
    //기존에 있는지 체크
    int checkCommonchecklistID(String memID);
}