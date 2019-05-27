import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

@Data
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
}