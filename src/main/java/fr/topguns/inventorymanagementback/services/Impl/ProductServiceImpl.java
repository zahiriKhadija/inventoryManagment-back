package fr.topguns.inventorymanagementback.services.Impl;

import fr.topguns.inventorymanagementback.models.Product;
import fr.topguns.inventorymanagementback.repositories.ProductRepository;
import fr.topguns.inventorymanagementback.services.IProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("L'entité n'a pas été trouvée pour l'ID : " + id));
    }

    @Override
    public Product getProductByProductName(String username) {
        return productRepository.findByProductName(username);
    }

    @Override
    public List<Product> findAllProductsByUser(Long idUser){
        return productRepository.findAllByIdUser(idUser);
    }
    @Override
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Boolean deleteProduct(Long productId) {
        //Todo : Tomorrow morning
        try{
            Product product = productRepository.findById(productId).orElseThrow();
            product.setQuantity(0);
            productRepository.save(product);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }
}
