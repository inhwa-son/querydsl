package com.web.gamego.service;

import com.web.gamego.repo.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

//    @Transactional(readOnly = true)
//    public List<Company> findAllLimitDesc (long offset, long limit) {
//        List<Company> articles = companyRepository.findAllLimitDesc(offset, limit);
////        List<ArticleCount> articleCounts = findArticleCounts(articles);
//
//        return new ArticleViewItems(articles, articleCounts).getArticleItems();
//    }



//    private List<ArticleCount> findArticleCounts(List<Article> articles) {
//        List<Long> articleIds = articles.stream().map(Article::getId).collect(Collectors.toList());
//        return articleCountRepository.findAllByArticleIdIn(articleIds);
//    }


}
