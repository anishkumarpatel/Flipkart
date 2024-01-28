package com.anish.golu.services.user;

import com.anish.golu.models.user.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    public static final String GET_ALL_USERS = "https://fakestoreapi.com/users";

    public List<User> getAllUsers() {
        /*
        public List<Product> getAllProducts() {

        FakeStoreProductDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
         */
        RestTemplate restTemplate = new RestTemplate();
        User[] response = restTemplate.getForObject(
                GET_ALL_USERS,
                User[].class);

        // Guard Condition
        assert response != null;
        return List.of(response);
    }
}
