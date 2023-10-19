package fr.topguns.inventorymanagementback.services;

import fr.topguns.inventorymanagementback.models.Customer;

import java.util.List;

public interface ICustomerService {

    public List<Customer> getAllUsers();
    public Customer getUserById(Long id);
    public Customer getUserByUsername(String username);
    public Customer getUserByEmail(String email);
    //public CustomerResponse findCustomersWithProduct(Long id);
    public Customer createUser(Customer user);
    public Customer updateUser(Customer user);
    public Boolean deleteUser(Long id);
}
