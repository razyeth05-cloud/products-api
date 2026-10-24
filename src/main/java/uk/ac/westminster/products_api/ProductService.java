package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.HashMap;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
//    private Map<Long, Product> products = new HashMap<>();

    private Long nextId = 1L;

    public ProductService(){
        products.add(new DigitalProduct(
                nextId++, "Clean Code (E-book)", 29.99,
                "/downloads/clean-code.pdf", 4.2));
        products.add(new PhysicalProduct(nextId++, "27-inch Monitor",
                249.99, 5.4, "61cm x 41cm x 18cm"));
    }

    public List<Product> getAllProducts() {
        return products;
    }
//    public List<Product> getAllProducts() {return products.values().stream().toList();}


    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }
//    public Product addProduct(Product product) {
//        product.setId(nextId++);
//        products.put(product.getId(), product);
//        return product;
//    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
//    public Optional<Product> getProductById(Long id) {
//        return Optional.ofNullable(products.get(id));}


    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }
//    public List<Product> findByName(String name) {
//        return products.values().stream()
//                .filter(p -> p.getName().contains(name))
//                .toList();
//    }

//    public List<Product> findCheaperThan(double price) {
//        return products.values().stream()
//                .filter(p -> p.getPrice() < price)
//                .toList();
//    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
//    public void deleteProduct(Long id) {
//        products.remove(id);
//    }

}