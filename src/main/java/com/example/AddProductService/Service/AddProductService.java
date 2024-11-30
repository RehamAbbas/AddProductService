package com.example.AddProductService.Service;

import com.example.AddProductService.Model.Product;
import com.example.AddProductService.Model.Request;
import com.example.AddProductService.Model.Response;
import com.example.AddProductService.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class AddProductService {

    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public AddProductService(ProductRepository productRepository, RestTemplate restTemplate) {
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }

    public Product addProduct(Product product) {
        Request request = new Request();
        request.setName(product.getName());

        String validationUrl = "http://localhost:8832/validate/name";

        try {
            ResponseEntity<Response> responseEntity =
                    restTemplate.postForEntity(validationUrl, request, Response.class);

            Response response = responseEntity.getBody();

            if (response != null) {
                System.out.println("Validation Response: " + response.getStatus() + " - " + response.getMessage());

                if (response.getStatus() == 200) {

                    return productRepository.save(product);
                } else {

                    throw new IllegalArgumentException(response.getMessage());
                }
            } else {

                throw new IllegalArgumentException("Validation failed: Response is null.");
            }
        } catch (RestClientException e) {

            throw new IllegalArgumentException("Failed to validate product 💔💔: " + e.getMessage(), e);
        }
    }
}
