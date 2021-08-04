package com.stock.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.app.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


}
