package com.rest.demoLab2.controller;

import java.util.ArrayList;
import java.util.List;

import com.exception.product.ProductNotFoundException;
import com.rest.demoLab2.model.Product;
import com.rest.demoLab2.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/v1/products"})
public class ProductController {

   private ProductService productService;

   ProductController(ProductService productService) {
       this.productService = productService;
   }

   @GetMapping(value = "/{id}")
   @ResponseBody
   public ResponseEntity<Product> findById(@PathVariable long id) {
       Product product = productService.findById(id);

       if (product == null) {
           throw new ProductNotFoundException("Product not found");
       }

       return new ResponseEntity<Product>(product, HttpStatus.OK);
   }

   @PostMapping(value = "/")
   @ResponseBody
   public ResponseEntity<Product> create(@RequestBody Product product  ) {
       Product newProduct = productService.create(product);

       if (newProduct == null) {
           //500?!?!
           throw  new InternalError("Something went wrong");
       }

       return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
   }

   @DeleteMapping(value = "/{id}")
   public ResponseEntity delete(@PathVariable long id) {
       try {
           productService.delete(id);
           return new ResponseEntity(HttpStatus.OK);
       } catch (Exception e) {
           throw new InternalError("Something went wrong");
       }
   }

   @PutMapping(value = "/")
   public ResponseEntity<Product> update(@RequestBody Product product) {
       try {
           Product updated = productService.update(product);
           return new ResponseEntity<>(updated, HttpStatus.OK);
       } catch (Exception e) {
           throw  new InternalError("Something went wrong");
       }
   }

   @GetMapping(value = "/tudo")
   public ResponseEntity<List<Product>> pegaTudo(){
       try {

            return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
            // return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
       } catch (Exception e){
            throw new ProductNotFoundException("Cagou irmao");
       }
   }

   @GetMapping(value = "search/{nome}")
   @ResponseBody
   public ResponseEntity<List<Product>> searchByName(@PathVariable String name){
       List<Product> produtos = productService.findAll();

       for (int i = produtos.size(); i >= 0; i--){
        if (name != produtos.get(i).getName()){
            produtos.remove(i);
        }
       }
       
       return new ResponseEntity<List<Product>>(produtos, HttpStatus.OK);
   }
   
}