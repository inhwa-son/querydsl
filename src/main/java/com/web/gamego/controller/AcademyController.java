package com.web.gamego.controller;

import com.web.gamego.repo.AcademyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/academy")
@CrossOrigin("*")
@Slf4j
public class AcademyController {


    @Autowired
    AcademyRepository academyRepository;


    @GetMapping("all")
    public List<?> selectAcademyAll() {
        List<?> tmp = academyRepository.findAll();

        log.debug("tmp => {}",tmp);
        return tmp;
    }


}
