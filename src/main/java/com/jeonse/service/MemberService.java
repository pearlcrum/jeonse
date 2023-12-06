package com.jeonse.service;

import com.jeonse.dto.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface MemberService {


    //회원가입
    void insertMem(MemberDTO member);

    // 아이디에 따른 회원정보
    MemberDTO getUserInfo(String memID);

    //아이디 중복 체크
    public int checkId(String memID);

    //내가 수정한 부분 아이디에 따른 모든 회원정보
    MemberDTO getMemberDTO(String memID);

    void updateMemberCredit(HashMap<String,Object> credit);

    void updateMemberIncome(HashMap<String,Object> income);
}
