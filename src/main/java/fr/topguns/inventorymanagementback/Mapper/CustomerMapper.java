package fr.topguns.inventorymanagementback.Mapper;
import fr.topguns.inventorymanagementback.dto.CustomerDto;
import fr.topguns.inventorymanagementback.models.Customer;
import org.modelmapper.ModelMapper;
public class CustomerMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public CustomerDto toDto(Customer customerEntity) {
        return modelMapper.map(customerEntity, CustomerDto.class);
    }

    public Customer fromDto(CustomerDto customerDto) {
        return modelMapper.map(customerDto, Customer.class);
    }
}
