import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/v1/products"})
public class ProductController {

   private ProductController productService;

   ProductController(ProductController productService) {
       this.productService = productService;
   }
}