package com.jeonse.config;

import com.jeonse.dto.MemberDTO;
import com.jeonse.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class LoginIdPwValidator implements UserDetailsService{

    @Autowired private MemberMapper memberMapper;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String memID) throws UsernameNotFoundException{
        MemberDTO user = memberMapper.getUserInfo(memID);
        System.out.println(user.getMemID());
        if(user == null) {
            System.out.println("유저가 없습니다."+user);
            throw new UsernameNotFoundException(memID);
        }

        /* 회원가입 구현 후 지워야함 */

        /*BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass = passwordEncoder.encode(user.getPass());*/

        String pass = user.getPass();
        String roles = "root";

        return User.builder()
                .username(memID)
                .password(pass)
                .roles(roles)
                .build();
    }

}