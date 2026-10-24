package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }


// POST /products returns only the parent class fields (id, name, price)
// because the controller accepts a Product object, so Jackson deserialises the
// request into Product rather than DigitalProduct. The subclass-specific fields
// (downloadUrl and fileSizeMB) are therefore not retained.
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }



    @GetMapping("/products/search")
    public List<Product> search(@RequestParam String name) {
        return productService.findByName(name);
    }

//    @GetMapping("/products/cheaper-than")
//    public List<Product> findCheaperThan(@RequestParam double price) {
//        return productService.findCheaperThan(price);
//    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
