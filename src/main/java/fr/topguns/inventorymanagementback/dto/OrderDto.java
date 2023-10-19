package fr.topguns.inventorymanagementback.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    private Long idOrder;
    private Long idUser;
    private LocalDateTime createDate;
    private boolean status;
    List<OrderDetailsDto> orderDetails = new ArrayList<>();
}
