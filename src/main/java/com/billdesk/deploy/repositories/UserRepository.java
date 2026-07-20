package com.billdesk.deploy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billdesk.deploy.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}