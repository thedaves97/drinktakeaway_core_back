package com.api.drinktakeaway_core_back.controller;

import com.api.drinktakeaway_core_back.dto.OrderDrinkQuantity;
import com.api.drinktakeaway_core_back.entity.DTA.Menu;
import com.api.drinktakeaway_core_back.entity.DTA.Order;
import com.api.drinktakeaway_core_back.repository.DTA.MenuRepository;
import com.api.drinktakeaway_core_back.repository.DTA.OrderRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/core")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/get_all_orders")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping(value = "/orders")
    @ResponseBody
    public List<Order> getOrdersByEmail(@RequestParam String email) {
        return orderRepository.findOrderByEmail(email);
    }

    @GetMapping(value = "/local_orders")
    @ResponseBody
    public List<Order> getOrdersBynameLocale(@RequestParam String nameLocale) {
        return orderRepository.findOrdersByNameLocale(nameLocale);
    }

    @GetMapping(value = "/get_drink_by_order_number")
    @ResponseBody
    public List<Order> getDrinksByOrderNumber(@RequestParam int orderNumber) {
        return orderRepository.findDrinksByNumberOrder(orderNumber);
    }

    @PostMapping(value = "/save_order", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> addOrder(@RequestBody JsonNode payload) {
        String localID = payload.get("localID").textValue();
        String userEmail = payload.get("userEmail").textValue();

        int lastOrderNumber = orderRepository.findMaxOrder();

        System.out.println(payload);

        for (JsonNode jsonNode : payload) {

            JsonNode drinkID = jsonNode.get("drinkID");
            JsonNode drinkPrice = jsonNode.get("drinkPrice");
            JsonNode drinkNumerosity = jsonNode.get("drinkNumerosity");

            if (drinkID != null && drinkPrice != null && drinkNumerosity != null) {

                Order order = new Order(userEmail, lastOrderNumber + 1, drinkNumerosity.asInt(), new Date(),
                        "processed");
                Menu menu = menuRepository.findMenuByIDs(Integer.parseInt(localID),
                        Integer.parseInt(drinkID.textValue()));

                order.setMenu(menu);

                order.setId_bevanda(menu.getId().getId_bevanda());
                order.setId_locale(menu.getId().getId_locale());

                orderRepository.save(order);
            }

        }

        HashMap<String, String> response = new HashMap<>();
        response.put("order", "ok");
        response.put("payment", "ok");

        return response;
    }

    @GetMapping(value = "/get_drink_quantity_to_do/{idLocale}")
    public int getOrderDrinkQuantity(@PathVariable(value = "idLocale") int idLocale) {
        return orderRepository.getOrderDrinkQuantity(idLocale);
    }

    @GetMapping(value = "/get_drink_quantity_to_do")
    public List<OrderDrinkQuantity> getOrderDrinkQuantity() {
        return orderRepository.getOrderDrinkQuantity();
    }

    @GetMapping(value = "/bartender/update_status_order")
    @ResponseBody
    @Transactional
    public boolean updateStatusOrder(@RequestParam String status, @RequestParam int orderNumber) {
        orderRepository.updateOrderStatus(status, orderNumber);
        return true;
    }
}