/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package product.service;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import product.dto.ProductRequest;
import product.dto.ProductResponse;
import product.model.ProductModel;
import product.repository.ProductRepository;
/**
 *
 * @author M. Iqbal Ramadlani
 */


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        ProductModel product = ProductModel.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<ProductModel> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(ProductModel product) {
        return new ProductResponse(product.getId(), product.getName(),
                product.getDescription(), product.getPrice());
    }
}
