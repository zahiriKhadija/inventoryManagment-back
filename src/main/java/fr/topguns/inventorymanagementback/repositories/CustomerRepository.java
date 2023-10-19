package fr.topguns.inventorymanagementback.repositories;

import fr.topguns.inventorymanagementback.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByUsername(String username);
    Customer findByEmail(String email);
}
