package com.example.AddProductService.Controller;


import com.example.AddProductService.Model.Product;
import com.example.AddProductService.Service.AddProductService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class AddProductController {

    private AddProductService addproductService;

    @Autowired
    public AddProductController(AddProductService addproductService) {
        this.addproductService = addproductService;
    }

    @GetMapping("/addProductPara")
    public Product addProductFromParams(
            @RequestParam String name,
            @RequestParam Double price,
            @RequestParam String description
    ) {

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);

        // Save the product using the service
        return addproductService.addProduct(product);
    }

    // For PostMan:
    @PostMapping("/addProduct")
    public Product saveProduct(@RequestBody Product product){
        return addproductService.addProduct(product);
 }

}



