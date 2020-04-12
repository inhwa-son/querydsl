package com.web.gamego.controller;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.web.gamego.entity.Company;
import com.web.gamego.model.PagingVO;
import com.web.gamego.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/company")
@CrossOrigin("*")
@Slf4j
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    private final JPAQueryFactory queryFactory;

    public CompanyController(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> selectCompanyAll(Company vo, HttpServletRequest request) {
//        @RequestParam(value = "offset") Long offset
        Map<String, Object> jsonObject = new HashMap<String, Object>();

        List<Company> articles = companyRepository.findAllLimitDesc(vo.getOffset(), vo.getLimit());
        jsonObject.put("data", articles);

        Long lstCount = queryFactory
                .selectFrom(company)
                .fetchCount();

        PagingVO pagingVO = new PagingVO(lstCount, vo.getOffset(), vo.getLimit());

        jsonObject.put("page", pagingVO);


        return new ResponseEntity<>(jsonObject, HttpStatus.OK);
    }




    @GetMapping("test")
    public Map<String, Object> test(Company vo, HttpServletRequest request) {
//        @RequestParam(value = "offset") Long offset
        Map<String, Object> jsonObject = new HashMap<String, Object>();

        List<?> data = companyRepository.findAllTest(vo.getOffset(), vo.getLimit());
        jsonObject.put("data", data);
        Long count_total = companyRepository.countAll();
        jsonObject.put("count_total", count_total);

        return jsonObject;
    }

}
