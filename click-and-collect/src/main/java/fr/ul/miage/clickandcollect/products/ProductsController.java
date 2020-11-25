package fr.ul.miage.clickandcollect.products;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductRepository repo;

    @GetMapping
    public Iterable<Product> getAllProducts() {
        return repo.findAll();
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public Product create(@RequestBody Product p) {
        return null;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {

    }

    @PutMapping("{id}")
    public Product update(@RequestBody Product p, @PathVariable Long id) {
        return null;
    }
}
