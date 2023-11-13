package com.jeonse.dto;

import lombok.Getter;

@Getter
public class MemberDto {
    String name;
    String id;
    String pass;
    String tel;
    String level;
    String quit;

    public MemberDto(String name,String id, String pass, String tel) {
        super();
        this.name = name;
        this.id = id;
        this.pass = pass;
        this.tel = tel;
    }

    public MemberDto(String name,String id, String pass, String tel, String level, String quit) {
        super();
        this.name = name;
        this.id = id;
        this.pass = pass;
        this.tel = tel;
        this.level = level;
        this.quit = quit;
    }

    public MemberDto() {
        // TODO Auto-generated constructor stub
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setQuit(String quit) {
        this.quit = quit;
    }
}
