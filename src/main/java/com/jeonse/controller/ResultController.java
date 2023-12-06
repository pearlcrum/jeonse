package com.jeonse.controller;

import com.jeonse.dto.CommonchecklistDTO;
import com.jeonse.dto.IbkansimjeonseDTO;
import com.jeonse.dto.IbkjeonseDTO;
import com.jeonse.dto.MemberDTO;
import com.jeonse.service.CommonchecklistService;
import com.jeonse.service.IbkansimjeonseService;
import com.jeonse.service.IbkjeonseService;
import com.jeonse.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.ArrayList;

@Controller
public class ResultController {
    @Autowired
    private CommonchecklistService commonchecklistService;

    @Autowired
    private IbkansimjeonseService ibkansimjeonseService;

    @Autowired
    private IbkjeonseService ibkjeonseService;

    @Autowired
    private MemberService memberService;


    @GetMapping("/result")
    public String result(@SessionAttribute(name="memID", required = false) String memID, Model model) {
        CommonchecklistDTO commonchecklistDTO=commonchecklistService.getCommonChecklist(memID);
        IbkansimjeonseDTO ibkansimjeonseDTO=ibkansimjeonseService.getIbkansimjeonseDTO(memID);
        IbkjeonseDTO ibkjeonseDTO=ibkjeonseService.getIbkjeonseDTO(memID);
        MemberDTO memberDTO=memberService.getMemberDTO(memID);
        String address=commonchecklistService.getAddress(memID);
        String name=memberDTO.getName();
        String pass=memberDTO.getPass();
        String tel=memberDTO.getTel();
        int level=memberDTO.getLevel();
        int quit=memberDTO.getQuit();
        int nice=memberDTO.getNice();
        int kcb=memberDTO.getKcb();
        int incomeLastYear=memberDTO.getIncomeLastYear();
        int incomeYearBeforeLast=memberDTO.getIncomeYearBeforeLast();
        int debt=memberDTO.getDebt();
        int birth=memberDTO.getBirth();
        int numhouse=memberDTO.getNumhouse();
        boolean agentCheck= commonchecklistDTO.isAgentCheck();
        boolean foriengerCheck= commonchecklistDTO.isForiengerCheck();
        boolean familyCheck=commonchecklistDTO.isFamilyCheck();
        int loanAmount=commonchecklistDTO.getLoanAmount();
        int housePrice=commonchecklistDTO.getHousePrice();
        int jeonseDeposit=commonchecklistDTO.getJeonseDeposit();
        int jeonseTerm=commonchecklistDTO.getJeonseTerm();
        int landlordPossessionMonth=commonchecklistDTO.getLandlordPossessionMonth();
        int seniorDebt=commonchecklistDTO.getSeniorDebt();
        boolean insurance=ibkansimjeonseDTO.isInsurance();
        boolean nearAgent=ibkansimjeonseDTO.isNearAgent();
        boolean shouldPayInTwoWeeks= ibkansimjeonseDTO.isShouldPayInTwoWeeks();
        boolean propertyRestrict=ibkansimjeonseDTO.isPropertyRestrict();
        boolean jeonip=ibkjeonseDTO.isJeonip();
        boolean confirmDate=ibkjeonseDTO.isConfirmDate();
        double interestRate=ibkjeonseDTO.getInterestRate();
        boolean nowJeonse=ibkjeonseDTO.isNowJeonse();
        boolean creditManagement=ibkjeonseDTO.isCreditManagement();
        boolean landLordPermit=ibkjeonseDTO.isLandLordPermit();

        //결과 값 및 안되는 사유 안내
        String ibkJeonseResult="대출 가능";
        String ibkAnsimJeonseResult="대출 가능";
        int ibkJeonseAmount=0;
        int ibkAnsimJeonseAmount=0;
        ArrayList<String> ibkJeonseReason=new ArrayList<>();
        ArrayList<String> ibkAnsimJeonseReason=new ArrayList<>();


        //안심전세 가능여부
        //birth 값 만 19세 이상이여야 함 바로 아래 if문 추가할 것
        if(!agentCheck) {
            ibkAnsimJeonseReason.add("공인중개업자를 통해 임대차계약을 체결하고, 임차보증금의 5% 이상에 해당하는 금액을 지급하여야 취급이 가능합니다.");
        }
        if(jeonseDeposit>700000000) {
            ibkAnsimJeonseReason.add("전세(임차)보증금이 7억 이하여야 취급이 가능합니다.");
        }
        if(jeonseTerm<12) {
            ibkAnsimJeonseReason.add("임대차기간이 1년 이상이어야 취급이 가능합니다.");
        }
        if(!insurance){
            ibkAnsimJeonseReason.add("전세금안심대출보증서(주택도시보증공사)발급 및 권리보험(손해보험사) 가입이 가능해야 취급이 가능합니다.");
        }
        if(kcb<520&&nice<600) {
            ibkAnsimJeonseReason.add("신용등급이 KCB 520점 이상이고, NICE 600점 이상이어야 취급이 가능합니다.");
        }
        if(creditManagement) {
            ibkAnsimJeonseReason.add("신용관리대상 정보를 보유한 경우 취급이 불가합니다.");
        }
        if(nearAgent) {
            ibkAnsimJeonseReason.add("임차물과 공인중개사의 위치가 원격지인 경우 취급이 불가능합니다.");
        }
        if(shouldPayInTwoWeeks) {
            ibkAnsimJeonseReason.add("계약일자와 잔금일 간의 기간이 14일 이내인 경우 취급이 불가능합니다.");
        }
        if(familyCheck) {
            ibkAnsimJeonseReason.add("임대인과 임차인의 관계가 배우자, 직계 존비속인 경우 취급이 불가능합니다.");
        }
        if(jeonseTerm>24) {
            ibkAnsimJeonseReason.add("전세기간이 24개월을 초과하면 취급이 불가능합니다.");
        }
        if(numhouse>=2){
            ibkAnsimJeonseReason.add("보유 주택 수가 2주택 이상인 경우 취급이 불가능합니다.");
        }
        if(foriengerCheck){
            ibkAnsimJeonseReason.add("임대인이 외국인인 경우 취급이 불가능합니다.");
        }

        //IBK안심전세 대출한도 산정
        if(housePrice*0.6<seniorDebt){
            ibkAnsimJeonseReason.add("선순위 채권이 주택가격의 60%를 초과하여 취급이 불가능합니다.");
            ibkAnsimJeonseResult="대출 불가능";
        }
        double returnAmount;
        returnAmount=housePrice*0.9-seniorDebt;
        int cb;
        if(kcb>=805 || nice>=820){
            cb=400000000;
        }else if(kcb>=655||nice>=740){
            cb=150000000;
        }else{
            cb=70000000;
        }
        if(numhouse==1){
            ibkAnsimJeonseAmount= (int) Math.min(200000000,Math.min(returnAmount*0.8,Math.min(jeonseDeposit*0.8,cb)));
        }else{
            ibkAnsimJeonseAmount=(int)Math.min(400000000,Math.min(returnAmount*0.8,Math.min(jeonseDeposit*0.8,cb)));
        }
        if(propertyRestrict){
            ibkAnsimJeonseResult="대출 불가능";
            ibkAnsimJeonseAmount=0;
            ibkAnsimJeonseReason.add("소유권 침해가 있는 경우 취급이 불가능합니다.");
        }
        if(!ibkAnsimJeonseReason.isEmpty()){
            ibkAnsimJeonseResult="대출 불가능";
            ibkAnsimJeonseAmount=0;
        }

        //ibk전세대출 가능여부
        //민법상 성년이어야 취급가능 birth 사용할 것
        if(!landLordPermit) {
            ibkJeonseReason.add("임대인이 임차보증반환채권 질권설정에 승낙하지 않은 경우 취급이 불가합니다.");
        }
        if(!agentCheck) {
            ibkJeonseReason.add("공인중개업자를 통해 임대차계약을 체결하고, 임차보증금의 5% 이상에 해당하는 금액을 지급하여야 취급이 가능합니다.");
        }
        if(!jeonip) {
            ibkJeonseReason.add("즉시 전입이 불가능한 경우 취급이 불가능합니다.");
        }
        if(!confirmDate) {
            ibkJeonseReason.add("확정일자가 없는 경우 취급이 불가능합니다.");
        }
        double customerPays; //소득대비 금융위험부담률
        //고객이 연간 부담하는 대출이자(본건 대출 포함) / 고객의 연소득 * 100
        // 본건 대출 제외 대출에 적용하는 이자 한은 가중평균 가계대출금리 5.24 + 1
        customerPays=((debt*6.24/100)+(loanAmount*interestRate/100))/incomeLastYear*100;
        System.out.println("현재 customerPays"+ customerPays);
        if(customerPays>40) {
            ibkJeonseReason.add("소득 대비 부채의 비중이 과도하여 취급이 불가능합니다.");
        }
        if(nowJeonse) {
            ibkJeonseReason.add("현재 타 금융기관에서 이용 중인 전세대출이 있는 경우 취급이 불가능합니다.");
        }
        if(numhouse>2) {
            ibkJeonseReason.add("보유 주택 수가 2주택 이상인 경우 취급이 불가능합니다.");
        }
        if(!insurance) {
            ibkJeonseReason.add("보증보험 가입이 불가능할 경우 취급이 불가능합니다.");
        }
        if(creditManagement) {
            ibkJeonseReason.add("신용관리대상 정보를 보유한 경우 취급이 불가합니다.");
        }
        if(landlordPossessionMonth==0) {
            ibkJeonseReason.add("임대인이 임차목적물을 소유한지 3개월 경과하지 않은 경우 취급이 불가능합니다.");
        }


        //ibkJeonse대출 가능 한도
        int jeonseCB=0;
        if(kcb>=805&&nice>=820){
            jeonseCB=500000000;
        }else if(kcb>=710&&nice>=775){
            jeonseCB=400000000;
        }else if(nice>=820){
            jeonseCB=300000000;
        }else if(kcb>=805){
            jeonseCB=300000000;
        }else if(kcb<=654&&nice<=739){
            jeonseCB=0;
        }else{
            jeonseCB=200000000;
        }
        if(numhouse==1){
            ibkJeonseAmount=(int)Math.min(jeonseCB,Math.min(300000000,Math.min(jeonseDeposit*0.8,housePrice*0.8-seniorDebt)));
        }else if(numhouse==0){
            ibkJeonseAmount=(int)Math.min(jeonseCB,Math.min(500000000,Math.min(jeonseDeposit*0.8,housePrice*0.8-seniorDebt)));
        }else{
            ibkJeonseAmount=0;
        }
        if(ibkJeonseAmount<0){
            ibkJeonseAmount=0;
        }
        if(ibkAnsimJeonseAmount<0){
            ibkAnsimJeonseAmount=0;
        }
        if(!ibkJeonseReason.isEmpty()){
            ibkJeonseResult="대출 불가능";
            ibkJeonseAmount=0;
        }


        model.addAttribute("address",address);
        model.addAttribute("housePrice",housePrice); //kb시세
        model.addAttribute("seniorDebt",seniorDebt); //선순위 채권
        model.addAttribute("loanAmount",loanAmount); // 대출 신청금액
        model.addAttribute("ibkJeonseResult",ibkJeonseResult);
        model.addAttribute("ibkAnsimJeonseResult",ibkAnsimJeonseResult);
        model.addAttribute("ibkJeonseAmount",ibkJeonseAmount);
        model.addAttribute("ibkAnsimJeonseAmount",ibkAnsimJeonseAmount);
        model.addAttribute("ibkJeonseReason",ibkJeonseReason);
        model.addAttribute("ibkAnsimJeonseReason",ibkAnsimJeonseReason);
        return "result";
    }
}
