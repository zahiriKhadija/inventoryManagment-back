package fr.topguns.inventorymanagementback.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long idOrder;
    private Long idUser;
    private String label;
    private String username;
    private Double total;
    private LocalDateTime createDate;
    private boolean status;
    private List<OrderDetailsDto> orderDetails;
}
