package com.delight.inventory_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delight.inventory_management.entity.OrderManagement;

@Repository
public interface OrderRepository extends JpaRepository<OrderManagement, Integer>{
	
	List<OrderManagement> findByType(String type);

}
