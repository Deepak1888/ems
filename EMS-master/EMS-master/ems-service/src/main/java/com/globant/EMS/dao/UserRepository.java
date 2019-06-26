package com.globant.EMS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.globant.EMS.model.Role;
import com.globant.EMS.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	 @Query("SELECT u FROM User u WHERE u.email = :email")
	    User findByUserEmail(@Param("email") String email);
	 
//	 @Query("SELECT r FROM User u JOIN Role r ON u.userId = r.user.userId WHERE u.email = :email")
	 @Query("SELECT r FROM User u JOIN u.roles r WHERE u.email = :email")
	    List<Role> getUserRoles(@Param("email") String email);
}
