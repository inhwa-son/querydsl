package com.web.gamego.repo;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.web.gamego.entity.Company;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.web.gamego.entity.QCompany.company;

/*
    fetch : 조회 대상이 여러건일 경우. 컬렉션 반환
    fetchOne : 조회 대상이 1건일 경우(1건 이상일 경우 에러). generic에 지정한 타입으로 반환
    fetchFirst : 조회 대상이 1건이든 1건 이상이든 무조건 1건만 반환. 내부에 보면 return limit(1).fetchOne() 으로 되어있음
    fetchCount : 개수 조회. long 타입 반환
    fetchResults : 조회한 리스트 + 전체 개수를 포함한 QueryResults 반환. count 쿼리가 추가로 실행된다.
 */

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
    @Override
    public Long countAll() {
        return queryFactory
                .selectFrom(company)
                .fetchCount();
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
