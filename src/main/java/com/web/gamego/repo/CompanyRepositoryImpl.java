package com.web.gamego.repo;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.web.gamego.entity.Company;
import lombok.RequiredArgsConstructor;

import java.util.List;



@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Company> findAllLimitDesc(long offset, long limit) {
        return queryFactory
                .selectFrom(company)
//                .leftJoin(article.facebooks).fetchJoin()
                .offset(offset)
                .limit(limit)
                .orderBy(company.id.desc())
                .fetch();
    }

    @Override
    public List<?> findAllTest(long offset, long limit) {
        return queryFactory
                .select(Projections.bean(Company.class, company.id.as("id"), company.companyName.as("companyName")))
                .from(company)
                .offset(offset)
                .limit(limit)
                .orderBy(company.id.desc())
                .fetch();
    }


//    @Override
//    public List<CompanyView> findAllViewLimitDesc(long offset, long limit) {
//        return queryFactory
//                .selectFrom(company)
//                .offset(offset)
//                .limit(limit)
//                .orderBy(company.id.desc())
//                .fetch();
//    }

    @Override
    public Long countAll() {
        return queryFactory
                .selectFrom(company)
//                .orderBy(company.id.desc())
                .fetchCount();
    }


//    @Override
//    public List<ArticleFacebook> findAllMostLikes(long offset, long limit, LocalDate today) {
//        return queryFactory
//                .selectFrom(articleFacebook)
//                .join(articleFacebook.article, article).fetchJoin()
//                .where(article.registrationDate.after(today.minusYears(1)))
//                .offset(offset)
//                .limit(limit)
//                .orderBy(articleFacebook.likes.desc())
//                .fetch();
//    }

}
