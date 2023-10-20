package fr.topguns.inventorymanagementback.services;

import fr.topguns.inventorymanagementback.config.Pagination;
import fr.topguns.inventorymanagementback.models.Order;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOrderService {

    public Page<Order> getAllOrders(Pagination pagination);
    public Order getOrderById(Long id);
    public Page<Order> getOrdersByIdUser(Long idUser, Pagination pagination);
    public Order createOrder(Order order);
    public Order updateOrder(Order order);
    public Boolean deleteOrder(Long orderId);
}
