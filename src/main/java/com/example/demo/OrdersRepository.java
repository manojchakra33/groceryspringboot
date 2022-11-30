package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	
//	@Query("select or from orders or order by or.products group by or.")
//	public List<TopSold> topSellingProducts();
	public List<Orders> findByUser(User user);
	
	

}
