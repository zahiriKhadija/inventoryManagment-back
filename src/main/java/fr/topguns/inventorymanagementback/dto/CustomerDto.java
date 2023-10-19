package fr.topguns.inventorymanagementback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createDate;
    private LocalDateTime editDate;
    private int isAdmin;
    private int isActive;
}
