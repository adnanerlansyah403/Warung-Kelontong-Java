package test.service;

import entity.Product;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;
import service.ProductService;
import service.ProductServiceImpl;

import java.util.List;

public class ProductServiceTest {

    public static void main(String[] args) {

        testRemoveProduct();

    }

    public static void testShowProducts() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        ProductService productService = new ProductServiceImpl(productRepository);
        productRepository.add(new Product("Mie Sedap Goreng", 5000, 50));
        productRepository.add(new Product("Mie Sedap Rebus", 10000, 50));
        productRepository.add(new Product("Pepsodent", 10000, 50));

        // Menampilkan semua produk menggunakan ProductService
        productService.showProducts();
    }

    public static void testAddProduct() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        ProductService productService = new ProductServiceImpl(productRepository);

        productRepository.add(new Product("Mie Sedap Goreng", 5000, 80));
        productRepository.add(new Product("Mie Sedap Rebus", 10000, 89));
        productRepository.add(new Product("Pepsodent", 10000, 70));

        // Menampilkan semua produk menggunakan ProductService
        productService.showProducts();
    }

    public static void testRemoveProduct() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        ProductService productService = new ProductServiceImpl(productRepository);

        productRepository.add(new Product("Mie Sedap Goreng", 5000, 100));
        productRepository.add(new Product("Mie Sedap Rebus", 10000, 50));
        productRepository.add(new Product("Pepsodent", 10000, 60));
        // Menampilkan semua produk menggunakan ProductService
        productService.showProducts();

        productService.removeProduct(5);
        productService.removeProduct(2);
        productService.showProducts();
        productService.removeProduct(2);
        productService.showProducts();
        productService.removeProduct(2);
        productService.showProducts();
        productService.removeProduct(1);
        productService.showProducts();
    }

}
