package fr.topguns.inventorymanagementback.controllers;

import fr.topguns.inventorymanagementback.Mapper.OrderMapper;
import fr.topguns.inventorymanagementback.config.Pagination;
import fr.topguns.inventorymanagementback.dto.OrderDto;
import fr.topguns.inventorymanagementback.models.Order;
import fr.topguns.inventorymanagementback.models.Status;
import fr.topguns.inventorymanagementback.services.IOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
    public Page<OrderDto> getAllOrders(Pagination pagination) {
        Page<Order> orderPage = orderService.getAllOrders(pagination);
        List<OrderDto> orderDtos = orderPage.getContent().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());

        return new PageImpl<>(orderDtos, PageRequest.of(pagination.getPage(), pagination.getSize()), orderPage.getTotalElements());
    }

    @GetMapping("/byId")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto getOrderById(@RequestParam(name = "id") Long id){
        return orderMapper.toDto(orderService.getOrderById(id));
    }

    @GetMapping("/byIdUser")
    @ResponseStatus(HttpStatus.OK)
    public Page<OrderDto> getOrdersByIdUser(@RequestParam(name = "idUser") Long idUser, @RequestBody Pagination pagination){
        Page<Order> orderPage = orderService.getOrdersByIdUser(idUser, pagination);
        List<OrderDto> orderDtos = orderPage.getContent().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());

        return new PageImpl<>(orderDtos, PageRequest.of(pagination.getPage(), pagination.getSize()), orderPage.getTotalElements());
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


    @DeleteMapping("/deleteOrder/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteOrder(@PathVariable("id") Long id){
        return orderService.deleteOrder(id)? "Order successfully deleted":"Error in deletion";
    }
}
