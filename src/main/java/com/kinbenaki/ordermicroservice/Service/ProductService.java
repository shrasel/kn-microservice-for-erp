package com.kinbenaki.ordermicroservice.Service;

import com.kinbenaki.ordermicroservice.Exception.ProductNotFoundException;
import com.kinbenaki.ordermicroservice.Model.Product;
import com.kinbenaki.ordermicroservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setUnitPrice(updatedProduct.getUnitPrice());
            existingProduct.setAvailableStockQuantity(updatedProduct.getAvailableStockQuantity());

            return productRepository.save(existingProduct);
        } else {
            // Handle case where product with given ID is not found
            throw new ProductNotFoundException("Product not found with ID: " + productId);
        }
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}

