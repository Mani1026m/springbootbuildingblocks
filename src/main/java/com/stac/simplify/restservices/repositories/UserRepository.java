package com.stac.simplify.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stac.simplify.restservices.entities.User;

//Repository
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
