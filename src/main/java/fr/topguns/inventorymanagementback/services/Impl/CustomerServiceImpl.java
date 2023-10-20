package fr.topguns.inventorymanagementback.services.Impl;

import fr.topguns.inventorymanagementback.models.Customer;
import fr.topguns.inventorymanagementback.repositories.CustomerRepository;
import fr.topguns.inventorymanagementback.services.ICustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository userRepository;

    @Override
    public List<Customer> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Customer getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("L'entité n'a pas été trouvée pour l'ID : " + id));
    }


    @Override
    public Customer getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    public Customer getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

  /*  @Override
    public CustomerResponse findCustomersWithProduct(Long id){
        var customer = userRepository.findById(id).orElse(CustomerEntity.builder()
                .username("not found")
                .email("not found")
                .password("not found")
                .createDate(LocalDateTime.now())
                .editDate(LocalDateTime.now())
                .isAdmin(0)
                .isActive(0)
                .build());
        var product = productClient.findAllProductsByUser(id);
        return CustomerResponse.builder()
                .username(customer.getUsername())
                .email(customer.getEmail())
                .password(customer.getPassword())
                .createDate(customer.getCreateDate())
                .editDate(customer.getEditDate())
                .isAdmin(customer.getIsAdmin())
                .isActive(customer.getIsActive())
                .products(product)
                .build();
    } */
    @Override
    public Customer createUser(Customer user){
        return userRepository.save(user);
    }

    @Override
    public Customer updateUser(Customer user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean deleteUser(Long userId) {
        //Todo : Tomorrow morning
        try{
            LocalDateTime date = LocalDateTime.now();
            Customer user = userRepository.findById(userId).orElseThrow();
            user.setIsActive(0);
            user.setEmail(user.getEmail() + "_deleted_" + date);
            userRepository.save(user);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }
}
