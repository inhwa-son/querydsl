package com.web.gamego.repo;

import com.web.gamego.entity.Company;

import java.util.List;

public interface CompanyRepositoryCustom {
    List<Company> findAllLimitDesc(long offset, long limit);

//    List<ArticleFacebook> findAllMostLikes(long offset, long limit, LocalDate today);
}
