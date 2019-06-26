package com.globant.EMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globant.EMS.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
