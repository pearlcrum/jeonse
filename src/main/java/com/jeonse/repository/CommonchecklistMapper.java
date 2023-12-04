package com.jeonse.repository;

import com.jeonse.dto.CommonchecklistDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonchecklistMapper {

    // 값 입력
    int insertCommonchecklist(CommonchecklistDTO commonchecklistDto);
    // 값 삭제
    void deleteCommonchecklist(String memID); // 값 삭제

    int checkCommonchecklistID(String memID); //중복 값 확인

    int getHouseIDFromCommonchecklist(String memID);

    CommonchecklistDTO getCommonChecklist(String memID);
}