package com.web.gamego.controller;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.web.gamego.entity.Company;
import com.web.gamego.entity_view.CompanyView;
import com.web.gamego.model.PagingVO;
import com.web.gamego.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.web.gamego.entity.QCompany.company;


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

    @GetMapping("select_page")
    public List<CompanyView> selectCompanyPage(Company vo, HttpServletRequest request) {
        return queryFactory
                .select(Projections.bean(CompanyView.class, company.id, company.companyName))
                .from(company)
//                .selectFrom(company)
                .where(eqDeleteAtIsNull()
//                        , eqCompanyName(vo.getCompanyName())
                        , eqCompanyNameLike(vo.getCompanyName())
                        , eqEmail(vo.getEmail())
//                        , eqCompanyName(vo.getCompanyName())
//                                .or(eqEmail(vo.getEmail()))
                )
                .offset(vo.getOffset())
                .limit(vo.getLimit())
                .orderBy(company.id.desc())
                .fetch();
    }

    @GetMapping("count_page")
    public Long countCompanyPage(Company vo, HttpServletRequest request) {
        return queryFactory
                .selectFrom(company)
                .where(eqDeleteAtIsNull()
                        , eqCompanyName(vo.getCompanyName())
                        , eqEmail(vo.getEmail()))
                .fetchCount();
    }


    @GetMapping("company_pagination")
    public QueryResults<CompanyView> companyPagination(Company vo, HttpServletRequest request) {
        return queryFactory
                .select(Projections.bean(CompanyView.class, company.id, company.companyName))
                .from(company)
                .where(eqDeleteAtIsNull()
                        , eqCompanyNameLike(vo.getCompanyName())
                        , eqEmail(vo.getEmail())
                )
                .offset(vo.getOffset())
                .limit(vo.getLimit())
                .orderBy(company.id.desc())
                .fetchResults();
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
    public ResponseEntity<Map<String, Object>> test(Company vo, HttpServletRequest request) {
//        @RequestParam(value = "offset") Long offset
        Map<String, Object> jsonObject = new HashMap<String, Object>();

        List<?> data = companyRepository.findAllTest(vo.getOffset(), vo.getLimit());
        jsonObject.put("data", data);
        Long count_total = companyRepository.countAll();
        jsonObject.put("count_total", count_total);

        return new ResponseEntity<>(jsonObject, HttpStatus.OK);
    }


    private BooleanExpression eqDeleteAtIsNull() {
        return company.deletedAt.isNull();
    }

    private BooleanExpression eqCompanyName(String companyName) {
        if (StringUtils.isEmpty(companyName)) {
            return null;
        }
        return company.companyName.eq(companyName);
    }

    private BooleanExpression eqCompanyNameLike(String companyName) {
        return StringUtils.isEmpty(companyName) ? null : company.companyName.contains(companyName);
//       1. contains 가 앞,뒤에 % 붙인역할
//       2. like => value + "%"
    }

    private BooleanExpression eqEmail(String email) {
        return StringUtils.isEmpty(email) ? null : company.email.eq(email);
    }

}
