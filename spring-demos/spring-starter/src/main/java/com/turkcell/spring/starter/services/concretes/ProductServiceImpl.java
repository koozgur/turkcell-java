package com.turkcell.spring.starter.services.concretes;

import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.repositories.abstracts.ProductRepository;
import com.turkcell.spring.starter.services.abstracts.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    //business flow (iş akışı)

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void add(Product product){
        if(product.getUnitPrice() < 0)
            throw new RuntimeException("Unit price cannot be less than 0.");
        productRepository.add(product);
        //call dataaccess if needed
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }
}
