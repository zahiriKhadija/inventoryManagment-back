package fr.topguns.inventorymanagementback.services.Impl;

import fr.topguns.inventorymanagementback.models.Order;
import fr.topguns.inventorymanagementback.repositories.OrderRepository;
import fr.topguns.inventorymanagementback.services.IOrderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        List<Order> list = orderRepository.findAll();
        return list ;
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("L'entité n'a pas été trouvée pour l'ID : " + id));
    }
    @Override
    public List<Order>  getOrdersByIdUser(Long idUser) {

        return orderRepository.findByIdUser(idUser);
    }

    @Override
    public Order createOrder(Order order){

        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        LocalDateTime date = LocalDateTime.now();
        order.setCreateDate(date);
        return orderRepository.save(order);
    }

    @Override
    public Boolean deleteOrder(Long orderId) {
        //Todo : Tomorrow morning
        try{
            LocalDateTime date = LocalDateTime.now();
            Order order = orderRepository.findById(orderId).orElseThrow();
            order.setStatus(true);
            orderRepository.save(order);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }
}
