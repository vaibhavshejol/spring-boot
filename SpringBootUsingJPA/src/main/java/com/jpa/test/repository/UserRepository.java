package com.jpa.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.jpa.test.entities.Users;

public interface UserRepository extends CrudRepository<Users,Integer> {

}
