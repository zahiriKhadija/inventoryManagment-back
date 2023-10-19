package fr.topguns.inventorymanagementback.controllers;

import fr.topguns.inventorymanagementback.Mapper.ProductMapper;
import fr.topguns.inventorymanagementback.dto.ProductDto;
import fr.topguns.inventorymanagementback.models.Product;
import fr.topguns.inventorymanagementback.services.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    @Autowired
    private IProductService productService;
    ProductMapper productMapper = new ProductMapper();

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> getProducts() {
        return  productService.getAllProducts().stream()
                .filter(product -> (product.getQuantity()>0))
                .sorted(Comparator.comparingLong(Product::getId))
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/byId")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto productById(@RequestParam(name = "id") Long id){
        return productMapper.toDto(productService.getProductById(id));
    }

    @GetMapping("/byProductName")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto productByProductName(@RequestParam(name = "productName") String productName){
        return productMapper.toDto(productService.getProductByProductName(productName));
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<List<ProductDto>> findAllProducts(@PathVariable("idUser") Long idUser){
        return  ResponseEntity.ok(productService.findAllProductsByUser(idUser).stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList()));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createProduct(@RequestBody ProductDto product){
        Product productCreated= productService.createProduct(productMapper.fromDto(product));
        return productMapper.toDto(productCreated);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto updateProduct(@RequestBody ProductDto product){
        Product productEntity = productMapper.fromDto(product);
        return productMapper.toDto(productService.updateProduct(productEntity));
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteProduct(@RequestParam(name = "id") Long id){
        return productService.deleteProduct(id)? "Product successfully deleted":"Error in deletion";
    }
}
