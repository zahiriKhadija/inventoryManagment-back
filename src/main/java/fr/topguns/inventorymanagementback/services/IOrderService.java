package fr.topguns.inventorymanagementback.services;

import fr.topguns.inventorymanagementback.models.Order;

import java.util.List;

public interface IOrderService {

    public List<Order> getAllOrders();
    public Order getOrderById(Long id);
    public List<Order> getOrdersByIdUser(Long idUser);
    public Order createOrder(Order order);
    public Order updateOrder(Order order);
    public Boolean deleteOrder(Long orderId);
}
