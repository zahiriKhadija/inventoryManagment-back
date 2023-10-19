package fr.topguns.inventorymanagementback.repositories;

import fr.topguns.inventorymanagementback.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByProductName(String productName);
    List<Product> findAllByIdUser(Long idUser);
}
