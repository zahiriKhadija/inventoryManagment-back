package fr.topguns.inventorymanagementback.Mapper;

import fr.topguns.inventorymanagementback.dto.ProductDto;
import fr.topguns.inventorymanagementback.models.Product;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public ProductDto toDto(Product productEntity) {
        return modelMapper.map(productEntity, ProductDto.class);
    }

    public Product fromDto(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }
}
