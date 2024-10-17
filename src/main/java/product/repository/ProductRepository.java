package product.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import product.model.ProductModel;

public interface ProductRepository extends MongoRepository<ProductModel, String> {
}