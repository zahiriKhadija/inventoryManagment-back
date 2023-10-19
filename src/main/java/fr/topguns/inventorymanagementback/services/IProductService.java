package fr.topguns.inventorymanagementback.services;

import fr.topguns.inventorymanagementback.models.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public Product getProductByProductName(String username);
    public List<Product> findAllProductsByUser(Long idUser);
    public Product createProduct(Product product);
    public Product updateProduct(Product user);
    public Boolean deleteProduct(Long userId);
}
