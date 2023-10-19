package fr.topguns.inventorymanagementback.controllers;

import fr.topguns.inventorymanagementback.Mapper.CustomerMapper;
import fr.topguns.inventorymanagementback.dto.CustomerDto;
import fr.topguns.inventorymanagementback.models.Customer;
import fr.topguns.inventorymanagementback.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    CustomerMapper customerMapper = new CustomerMapper();

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getUsers() {
        return  customerService.getAllUsers().stream()
                .filter(user -> (user.getIsAdmin() == 0 && user.getIsActive()==1))
                .sorted(Comparator.comparingLong(Customer::getId))
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/byId")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto userById(@RequestParam(name = "id") Long id){
        return customerMapper.toDto(customerService.getUserById(id));
    }

    @GetMapping("/byEmail")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto userByEmail(@RequestParam(name = "email") String email){
        return customerMapper.toDto(customerService.getUserByEmail(email));
    }

    @GetMapping("/byUsername")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto userByUsername(@RequestParam(name = "username") String username){
        return customerMapper.toDto(customerService.getUserByUsername(username));
    }
    /*@GetMapping("/withProduct/{id}")
    public ResponseEntity<CustomerResponse> findALlCustomers(@PathVariable("idUser") Long id){
        return ResponseEntity.ok(customerService.findCustomersWithProduct(id));
    } */

    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createUser(@RequestBody CustomerDto user){
        Customer userCreated= customerService.createUser(customerMapper.fromDto(user));
        return customerMapper.toDto(userCreated);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto updateUser(@RequestBody CustomerDto user){
        Customer customerEntity = customerMapper.fromDto(user);
        return customerMapper.toDto(customerService.updateUser(customerEntity));
    }

    @DeleteMapping("/remove")
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@RequestParam(name = "id") Long id){
        return customerService.deleteUser(id)? "User successfully deleted":"Error in deletion";
    }
}