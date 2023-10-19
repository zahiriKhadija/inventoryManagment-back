package fr.topguns.inventorymanagementback.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderDetail")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long idProduct;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private Long quantity;
}
