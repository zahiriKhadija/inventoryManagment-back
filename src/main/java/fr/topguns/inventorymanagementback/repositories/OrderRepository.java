package fr.topguns.inventorymanagementback.repositories;


import fr.topguns.inventorymanagementback.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepository extends JpaRepository<Order,Long> {
    Page<Order> findByIdUser(Long idUser, Pageable pageable);
}
