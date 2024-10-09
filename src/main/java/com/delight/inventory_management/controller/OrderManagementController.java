package com.delight.inventory_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delight.inventory_management.dto.RestockPlanDTO;
import com.delight.inventory_management.entity.OrderManagement;
import com.delight.inventory_management.service.OrderService;

@RestController
@RequestMapping(path = "/order")
public class OrderManagementController {

	@Autowired
	private OrderService orderService;

	@GetMapping
	private List<OrderManagement> getAllOrder() {
		return orderService.getAllOrders();
	}

	@PostMapping("/sales")
	public OrderManagement createSO(@RequestBody OrderManagement orderManagement) {
		return orderService.createOrder(orderManagement);
	}

	@GetMapping("/calculate/restockPlan")
	public List<RestockPlanDTO> calculateRestockPlan() {
		
		System.out.println("CALLED RESTOCK PLAN.");
		return orderService.calculateRestockPlan();
	}

	@PostMapping("/purchase")
	public OrderManagement createPO(@RequestBody OrderManagement orderManagement) {
		return orderService.createOrder(orderManagement);
	}

	@GetMapping("/{id}")
	public OrderManagement getById(@PathVariable int id) throws Exception {
		return orderService.getOrdersById(id);
	}

}
