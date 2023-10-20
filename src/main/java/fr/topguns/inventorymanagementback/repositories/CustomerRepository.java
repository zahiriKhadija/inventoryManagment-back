package fr.topguns.inventorymanagementback.repositories;

import fr.topguns.inventorymanagementback.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
   Customer findByUsername(String username);
   Optional<Customer> findByEmail(String email);
}
