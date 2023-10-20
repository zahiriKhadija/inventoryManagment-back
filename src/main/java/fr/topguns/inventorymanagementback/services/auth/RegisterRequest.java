package fr.topguns.inventorymanagementback.services.auth;

import fr.topguns.inventorymanagementback.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Role role;
}
