package product.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import product.dto.ProductRequest;
import product.dto.ProductResponse;
import product.service.ProductService;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService productService = null;

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void createProduct(@RequestBody ProductRequest productRequest) {
            productService.createProduct(productRequest);
        }

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<ProductResponse> getAllProducts() {
            return productService.getAllProducts();
        }
    }
