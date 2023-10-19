package fr.topguns.inventorymanagementback.dto;

import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String productName;
    private int quantity;
    private Long price;
    private String picture;
    private int idUser;

}
