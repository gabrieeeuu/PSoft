package com.rest.demoLab2.service;

import java.util.List;

import com.exception.product.ProductNotFoundException;
import com.rest.demoLab2.dao.ProductDAO;
import com.rest.demoLab2.model.Product;

import org.springframework.stereotype.Service;



@Service
public class ProductService {

   private final ProductDAO productDAO;

   ProductService(ProductDAO productDAO) {
       this.productDAO = productDAO;
   }

   public Product create(Product product) {
       return productDAO.save(product);
   }

   public Product update(Product productToUpdate) throws ProductNotFoundException {


       Product product = productDAO.findById(productToUpdate.getId());
       if (product == null)
           throw new  ProductNotFoundException("Could not update. The product does not exist.");

       return productDAO.save(productToUpdate);
   }

   public void delete(long id) {
       productDAO.deleteById(id);
   }

   public Product findById(long id) {
       return productDAO.findById(id);
   }

   public List<Product> findAll(){
       return productDAO.findAll();
   }

}
