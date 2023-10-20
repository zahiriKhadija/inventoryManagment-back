package fr.topguns.inventorymanagementback.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RoleDto {
    private Long id;
    private String roleName;

    @JsonIgnore
    private CustomerDto customerDto;
}
