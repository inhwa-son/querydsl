package com.web.gamego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/company")
public class CompanyFrontController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String openList(Model model, HttpServletRequest request) {
        return "companyList";
    }


}
