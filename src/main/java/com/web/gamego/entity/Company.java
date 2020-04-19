package com.web.gamego.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.web.gamego.model.SimplePagingVO;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor(access = AccessLevel.PUBLIC)
//@EqualsAndHashCode()
@Entity
@Data
@Table(name = "company")
public class Company  {
//extends SimplePagingVO

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint comment '고유 ID'")
    private Long id;

    @Column(name = "company_name", columnDefinition = "varchar(32) comment '회사 이름'")
    private String companyName;

    @Column(name = "tel", columnDefinition = "varchar(12) comment '연락처'")
    private String tel;

    @Column(name = "email", columnDefinition = "varchar(54) comment '이메일 주소'")
    String email;

    @Column(name = "test_bigint", columnDefinition = "bigint comment '테스트용' ")
    String testBigint;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at", columnDefinition = "datetime comment '작성일'")
    private Date createdAt;  // 작성일

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at", columnDefinition = "datetime comment '수정일'")
    private Date updatedAt;  // 수정일

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "deleted_at", columnDefinition = "datetime comment '삭제일'")
    private Date deletedAt;


    @Builder
    public Company(String companyName, String tel, String email, String testBigint, Date createdAt) {
        this.companyName = companyName;
        this.tel = tel;
        this.email = email;
        this.testBigint = testBigint;
        this.createdAt = createdAt;
    }

    private Long offset;
    private Long limit;



}
