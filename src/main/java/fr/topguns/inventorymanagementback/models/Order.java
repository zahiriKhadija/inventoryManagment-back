package fr.topguns.inventorymanagementback.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;
    @Column(nullable = false)
    private Long idUser;
    @Column(length = 50,nullable = false)
    private String username;
    @Column(nullable = false)
    private String label;
    @Column(nullable = false)
    private LocalDateTime createDate;
    @Column(nullable = false)
    private boolean status;
    @Column(nullable = false)
    private Double total;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;
}
