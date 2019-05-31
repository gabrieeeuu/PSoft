package com.rest.demoLab2.dao;

import com.rest.demoLab2.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

import java.util.List;


@Repository
public interface ProductDAO<T, ID extends Serializable> extends JpaRepository<Product, Long> {

   Product save(Product product);

   Product findById(long id);

   List<Product> findAll();

}
