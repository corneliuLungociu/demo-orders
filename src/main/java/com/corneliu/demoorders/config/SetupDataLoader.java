package com.corneliu.demoorders.config;

import com.corneliu.demoorders.model.entities.ProductEntity;
import com.corneliu.demoorders.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {

        productRepository.save(createProduct(1, "Product 1"));
        productRepository.save(createProduct(2, "Product 2"));
    }

    private ProductEntity createProduct(long id, String name) {
        ProductEntity entity = new ProductEntity();
        entity.setId(id);
        entity.setName(name);

        return entity;
    }


}