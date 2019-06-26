package com.globant.EMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globant.EMS.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
