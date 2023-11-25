package com.jeonse.service;
import com.jeonse.dto.MemberDTO;
import com.jeonse.repository.MemberMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberMapper memberMapper;

    @Override
    public void insertMem(@NotNull MemberDTO member) {
        MemberDTO memberDto = new MemberDTO();
        memberDto.setMemID( member.getMemID());
        memberDto.setPass(member.getPass());


        System.out.println("서비스에서 나와"+member);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPass(passwordEncoder.encode(member.getPass()));

        memberMapper.insertMem(member);

        System.out.println("서비스에서 암호화된 비밀번호야"+member.getPass());
        System.out.println("서비스에서 암호화하구 나와"+member);
    }


    @Override
    public MemberDTO getUserInfo(String memID) {
        MemberDTO user = memberMapper.getUserInfo(memID);
        System.out.println("로그인한 친구 정보야"+user);
        return user;
    }


    @Override
    public int checkId(String memID) {
        int cnt = memberMapper.checkId(memID);
        System.out.println("serviceImpl >> " + cnt);
        return cnt;
    }
}
