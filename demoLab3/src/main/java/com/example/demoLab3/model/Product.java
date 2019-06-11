package com.example.demoLab3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   private String name;
   private String description;
   private float price;

   public Product() {

   }

   public Product(String name, String description, float price) {
       this.name = name;
       this.description = description;
       this.price = price;
   }

   /**
    * @return the name
    */
   public String getName() {
       return name;
   }
   
   /**
    * @return the id
    */
   public long getId() {
       return id;
   }

   /**
    * @return the price
    */
   public float getPrice() {
       return price;
   }

   /**
    * @return the description
    */
   public String getDescription() {
       return description;
   }
}