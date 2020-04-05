package com.web.gamego.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint comment '고유 ID'")
    Long id;
//    private String name;

    @Column(name = "company_name", columnDefinition = "varchar(32) comment '회사 이름'")
    String companyName;

    @Column(name = "tel", columnDefinition = "varchar(12) comment '연락처'")
    String tel;

    @Column(name = "email", columnDefinition = "varchar(54) comment '이메일 주소'")
    String email;

    @Column(name = "test_bigint", columnDefinition = "bigint comment '테스트용' ")
    String testBigint;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at", columnDefinition = "datetime comment '작성일'")
    Date createdAt;  // 작성일

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at", columnDefinition = "datetime comment '수정일'")
    Date updatedAt;  // 수정일

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "deleted_at", columnDefinition = "datetime comment '삭제일'")
    Date deletedAt;




//    @Builder
//    public Company(String name, String address) {
//        this.name = name;
//        this.address = address;
//    }
}
