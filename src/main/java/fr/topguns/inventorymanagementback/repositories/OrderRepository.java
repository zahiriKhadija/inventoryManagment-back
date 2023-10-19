package fr.topguns.inventorymanagementback.repositories;

import fr.topguns.inventorymanagementback.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByIdUser(Long idUser);
}
