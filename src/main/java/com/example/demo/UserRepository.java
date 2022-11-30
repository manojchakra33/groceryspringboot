package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer>{
	
//	@Modifying
//	@Query(
//	  value = 
//	    "insert into User values (:name, :age, :email, :status)",
//	  nativeQuery = true)
//	void insertUser(@Param("city_village") String vity_village, @Param("district") String district, 
//	  @Param("status") Integer status, @Param("email") String email,Param("email") String email,Param("email") String email);
	
	public User findBymobileNumber(Long number);
	public User findBylogin(Login login);

}
