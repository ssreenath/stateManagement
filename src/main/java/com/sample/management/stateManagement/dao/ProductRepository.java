package com.sample.management.stateManagement.dao;

import com.sample.management.stateManagement.domain.entity.Product;
import com.sample.management.stateManagement.domain.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByUser(@Param("user") User user);



}