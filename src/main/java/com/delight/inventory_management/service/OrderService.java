package com.delight.inventory_management.service;

import java.util.List;

import com.delight.inventory_management.dto.RestockPlanDTO;
import com.delight.inventory_management.entity.OrderManagement;

public interface OrderService {

	OrderManagement createOrder(OrderManagement orderManagement);
	List<OrderManagement> getAllOrders();
	OrderManagement getOrdersById(int id) throws Exception;
	OrderManagement update(OrderManagement orderManagement) throws Exception;
	List<RestockPlanDTO> calculateRestockPlan();
	
}
