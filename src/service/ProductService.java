package service;

import entity.Product;

public interface ProductService {

    void showProducts();

    void addProduct(String name, Integer price, Integer quantity);

    void removeProduct(Integer number);

    int getProductSize();

    void addProduct(Product product);

    Product findProductByName(String name);

    void reduceProductStock(String name, int quantity);
}
