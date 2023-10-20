package fr.topguns.inventorymanagementback.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDto {

    private Long id;
    private Long idProduct;
    private double price;
    private Long quantity;
}
