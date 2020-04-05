package com.web.gamego.controller;

import com.web.gamego.entity.Company;
import com.web.gamego.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
@CrossOrigin("*")
@Slf4j
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("all")
    public List<Company> selectCompanyAll() {
//        @RequestParam(value = "offset") Long offset
        int offset = 600;
        int limit = 10;
        List<Company> articles = companyRepository.findAllLimitDesc(offset, limit);


        return articles;
    }


}
