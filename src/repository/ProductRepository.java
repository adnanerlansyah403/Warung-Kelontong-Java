package repository;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepository {

    List<Product> get();

    ArrayList<Product> getAll();

    void add(Product product);

    boolean remove(Integer number);

    boolean removeByName(String name);

    Product findByName(String name);

}
