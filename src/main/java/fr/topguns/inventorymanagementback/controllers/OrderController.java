package fr.topguns.inventorymanagementback.controllers;

import fr.topguns.inventorymanagementback.Mapper.OrderMapper;
import fr.topguns.inventorymanagementback.dto.OrderDto;
import fr.topguns.inventorymanagementback.models.Order;
import fr.topguns.inventorymanagementback.services.IOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    @Autowired
    private IOrderService orderService;
    OrderMapper orderMapper = new OrderMapper();


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> getAllOrders() {
        return  orderService.getAllOrders().stream()
                .filter(Order::isStatus)
                .sorted(Comparator.comparingLong(Order::getIdOrder))
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/byId")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto getOrderById(@RequestParam(name = "id") Long id){
        return orderMapper.toDto(orderService.getOrderById(id));
    }

    @GetMapping("/byIdUser")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> getOrdersByIdUser(@RequestParam(name = "idUser") Long idUser){
        return  orderService.getOrdersByIdUser(idUser).stream()
                .filter(Order::isStatus)
                .sorted(Comparator.comparingLong(Order::getIdOrder))
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }
    @PostMapping("/createOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@RequestBody OrderDto order){
        Order orderEntity = orderMapper.fromDto(order);
        Order orderCreated= orderService.createOrder(orderEntity);
        return orderMapper.toDto(orderCreated);
    }

    @PutMapping("/updateOrder")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto updateOrder(@RequestBody OrderDto order){
        Order orderEntity = orderMapper.fromDto(order);
        return orderMapper.toDto(orderService.updateOrder(orderEntity));
    }


    @DeleteMapping("/deleteOrder")
    @ResponseStatus(HttpStatus.OK)
    public String deleteOrder(@RequestParam(name = "id") Long id){
        return orderService.deleteOrder(id)? "Order successfully deleted":"Error in deletion";
    }
}
