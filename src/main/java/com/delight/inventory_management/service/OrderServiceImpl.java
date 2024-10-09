package com.delight.inventory_management.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delight.inventory_management.dto.RestockPlanDTO;
import com.delight.inventory_management.entity.OrderManagement;
import com.delight.inventory_management.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public OrderManagement createOrder(OrderManagement orderManagement) {
		orderManagement.setTimestamp(new Date());
		return orderRepository.save(orderManagement);
	}

	@Override
	public List<OrderManagement> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public OrderManagement getOrdersById(int id) throws Exception {
		return orderRepository.findById(id).orElseThrow(() -> new Exception());
	}

	@Override
	public OrderManagement update(OrderManagement orderManagement) throws Exception {
		OrderManagement orderManagementExist = orderRepository.findById(orderManagement.getId())
				.orElseThrow(() -> new Exception());

		BeanUtils.copyProperties(orderManagement, orderManagementExist);
		return orderRepository.save(orderManagementExist);
	}

	@Override
	public List<RestockPlanDTO> calculateRestockPlan() {
		// TODO Auto-generated method stub

		List<OrderManagement> salesDetails = orderRepository.findByType("Sales");
		
		Map<Integer, List<Double>> salesMap = new HashMap<>();
		for (OrderManagement sales : salesDetails) {
			Double qty = sales.getQuantity();
			salesMap.computeIfAbsent(sales.getProduuctId(), k -> new ArrayList<Double>()).add(qty);
		}
 
		List<RestockPlanDTO> restockPlans = new ArrayList<RestockPlanDTO>();
		for (Map.Entry<Integer, List<Double>> entry : salesMap.entrySet()) {
			Integer productID = entry.getKey();
			List<Double> sales = entry.getValue();

			Double dailyAverage = sales.stream().mapToDouble(Double::doubleValue).sum() / sales.size();
			Double recommendedQty = dailyAverage * 7;   

			restockPlans.add(new RestockPlanDTO(productID, recommendedQty));
		}
		
		
		System.out.println(restockPlans.toString());
		return restockPlans; 
	}

}
