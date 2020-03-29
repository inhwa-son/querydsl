package com.web.gamego.repo;

import com.web.gamego.entity.Foo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FooRepository extends JpaRepository<Foo, Long> {
    Foo findByBar(String bar);

//    Iterable<Foo> findAll(BooleanBuilder builder);
}
