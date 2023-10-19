package fr.topguns.inventorymanagementback.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "UserTable")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50,nullable = false)
    private String username;
    @Column(length = 80,nullable = false)
    private String email;
    @Column(length = 14,nullable = false)
    private String password;
    @Column
    private LocalDateTime createDate;
    @Column
    private LocalDateTime editDate;
    @Column(nullable = false)
    private int isAdmin;
    @Column(nullable = false)
    private int isActive;
}
