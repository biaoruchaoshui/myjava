package com.xzb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//做服务端跳转用的
@Controller
@RequestMapping("")
public class PageController {
    @RequestMapping("registerPage")
    public String registerPage() {
        return "fore/register2";
    }
    @RequestMapping("registerSuccessPage")
    public String registerSuccessPage() {
        return "fore/registerSuccess";
    }
    @RequestMapping("loginPage")
    public String loginPage() {
        return "fore/login2";
    }
    @RequestMapping("foreFindLost")
    public String alipay(){
        return "fore/foreFindLost";
    }
    @RequestMapping("toadminLogin")
    public String AdminloginPage() {
        return "fore/back";
    }
/*
    @RequestMapping("toforeClaim")
    public String toClaim(){
    	return "fore/foreClaim";
    }*/
    	
}