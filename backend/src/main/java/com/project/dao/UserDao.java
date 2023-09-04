package com.project.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entities.User;

@Repository
public interface UserDao  extends JpaRepository<User, Integer>
{

 User findByEmail(String Email);
}
