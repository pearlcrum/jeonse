package com.jeonse.dto;

import lombok.Data;
import org.springframework.context.annotation.Bean;


@Data

public class MemberDTO {
    private String memID;
    private String name;
    private String pass;
    private String tel;
    private int level;
    private int quit;
    private int nice;
    private int kcb;
    private int incomeLastYear;
    private int incomeYearBeforeLast;
    private int debt;
    private int birth;
    private int numhouse;
    private int checklistID;


}