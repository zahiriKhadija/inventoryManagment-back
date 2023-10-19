package fr.topguns.inventorymanagementback.dto;

import fr.topguns.inventorymanagementback.models.Order;

public class OrderDetailsDto {

    private Long id;
    private Long idProduct;
    private double price;
    private Long quantity;
    private Order order;
}
