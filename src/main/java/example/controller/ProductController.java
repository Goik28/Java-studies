package example.controller;

import example.model.Product;
import example.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepo productRepository;

    @PostMapping("/product")
    @ResponseBody
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
    @GetMapping("/product/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }
}