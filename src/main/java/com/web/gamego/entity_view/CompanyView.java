package com.web.gamego.entity_view;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.web.gamego.model.SimplePagingVO;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyView {

    private Long id;
    private String companyName;

    private String tel;
    String email;
    String testBigint;


}
