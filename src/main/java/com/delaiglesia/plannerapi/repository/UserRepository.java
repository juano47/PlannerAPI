package com.delaiglesia.plannerapi.repository;

import com.delaiglesia.plannerapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
