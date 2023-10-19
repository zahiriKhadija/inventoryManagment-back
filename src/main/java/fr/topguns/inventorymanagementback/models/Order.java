package fr.topguns.inventorymanagementback.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;
    @Column(nullable = false)
    private Long idUser;
    @Column(nullable = false)
    private LocalDateTime createDate;
    @Column(nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    List<OrderDetails> orderDetails = new ArrayList<>();


}
