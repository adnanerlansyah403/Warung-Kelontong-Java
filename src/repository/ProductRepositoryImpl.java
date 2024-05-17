package repository;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private ArrayList<Product> products = new ArrayList<>();


    public ArrayList<Product> getAll() {
        return products;
    }

    @Override
    public List<Product> get() {
        return List.of();
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public boolean remove(Integer number) {
        if (number < 1 || number > products.size()) return false;

        products.remove(number - 1);
        return true;
    }

    @Override
    public Product findByName(String name) {
        for (Product product : products) {
            if(product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public boolean removeByName(String name) {
        Product product = findByName(name);
        if (product != null) {
            products.remove(product);
            return true;
        }
        return false;
    }


}
