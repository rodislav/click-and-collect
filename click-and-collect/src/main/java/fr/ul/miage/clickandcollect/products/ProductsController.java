package fr.ul.miage.clickandcollect.products;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    @GetMapping
    public List<Product> getAllProducts() {
        return null;
    }

}
