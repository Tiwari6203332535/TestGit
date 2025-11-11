package com.happy.service;

import com.happy.entity.Product;
import com.happy.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //Add product
    public Product addProduct(Product product) {
        System.out.println(product);
        Product save = productRepository.save(product);
        return save;
    }

    //Get product by id
    public Product getProductById(int id) {
        Optional<Product> byId = productRepository.findById(id);
        Product product = byId.get();
        return product;
    }

    //Get All prduct
    public List<Product> getAllProduct() {
        List<Product> all = productRepository.findAll();
        return all;
    }

    //Delete Product
    public Boolean deleteById(int id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //Update Product
    public Product updateProduct(Product product) {
        int id = product.getId();
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            Product product1 = new Product();
            //  product1.setId(product.getId());
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setQuantity(product.getQuantity());
            return productRepository.save(product1);
        } else {
            return productRepository.save(product);
        }
    }

}
