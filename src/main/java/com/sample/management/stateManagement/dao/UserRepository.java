package com.sample.management.stateManagement.dao;

import com.sample.management.stateManagement.domain.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);



}