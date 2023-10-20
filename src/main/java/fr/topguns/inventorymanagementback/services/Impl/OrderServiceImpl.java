package fr.topguns.inventorymanagementback.services.Impl;

import fr.topguns.inventorymanagementback.config.Pagination;
import fr.topguns.inventorymanagementback.models.Order;
import fr.topguns.inventorymanagementback.models.Status;
import fr.topguns.inventorymanagementback.repositories.OrderRepository;
import fr.topguns.inventorymanagementback.services.IOrderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<Order> getAllOrders(Pagination pagination) {
        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getSize());
        return orderRepository.findAll(pageable);

    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("L'entité n'a pas été trouvée pour l'ID : " + id));
    }
    @Override
    public Page<Order>  getOrdersByIdUser(Long idUser,Pagination pagination) {
        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getSize());
        return orderRepository.findByIdUser(idUser,pageable);
    }

    @Override
    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Boolean deleteOrder(Long orderId) {
        //Todo : Tomorrow morning
        try{
            Order order = orderRepository.findById(orderId).orElseThrow();
            order.setStatus(Status.REJECT);
            orderRepository.save(order);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }
}
