package service;

import entity.Product;
import repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void showProducts() {
        List<Product> products = productRepository.getAll();
        int no = 1;
        for (Product product : products) {
            if(product != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(no)
                        .append(". ")
                        .append(product.getName())
                        .append(" (")
                        .append(product.getPrice())
                        .append(")")
                        .append(" (")
                        .append(product.getQuantity())
                        .append(")");
                System.out.println(sb.toString());
                no++;
            }
        }
    }

    @Override
    public void addProduct(String name, Integer price, Integer quantity) {
        Product product = new Product(name, price, quantity);
        productRepository.add(product);
        System.out.println("Sukses menambah data product " + product);
    }

    @Override
    public void removeProduct(Integer number) {
        boolean success = productRepository.remove(number);
        if(success) System.out.println("Sukses menghapus product : " + number);
        else System.out.println("Gagal menghapus product : " + number);
    }

    public int getProductSize() {
        return productRepository.getAll().size();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.add(product);
        System.out.println("Sukses menambah data product " + product);
    }

    @Override
    public Product findProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void reduceProductStock(String name, int quantity) {
        Product product = productRepository.findByName(name);
        if(product != null) {
            product.setStock(product.getStock() - quantity);
            if(product.getStock() == 0) {
                productRepository.removeByName(product.getName());
            }
        }
    }
}
