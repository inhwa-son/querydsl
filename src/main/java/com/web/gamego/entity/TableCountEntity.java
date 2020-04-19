package com.web.gamego.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "table_count")
public class TableCountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "table_count")
    private Long tableCount;


}
