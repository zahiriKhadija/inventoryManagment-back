package fr.topguns.inventorymanagementback.Mapper;

import fr.topguns.inventorymanagementback.dto.OrderDto;
import fr.topguns.inventorymanagementback.models.Order;
import org.modelmapper.ModelMapper;

public class OrderMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public OrderDto toDto(Order orderEntity) {

        return modelMapper.map(orderEntity, OrderDto.class);
    }

    public Order fromDto(OrderDto orderDto) {

        return modelMapper.map(orderDto, Order.class);
    }
}
