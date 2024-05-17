package test.view;

import entity.Product;
import repository.MoneyRepository;
import repository.MoneyRepositoryImpl;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;
import service.MoneyService;
import service.MoneyServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;
import view.MoneyView;
import view.ProductView;

public class ProductViewTest {

    public static void main(String[] args) {
        testShowProducts();
    }

    public static void testShowProducts() {
        // Money
        MoneyRepository moneyRepository = new MoneyRepositoryImpl();
        MoneyService moneyService = new MoneyServiceImpl(moneyRepository);
        ProductRepository productRepository = new ProductRepositoryImpl();
        ProductService productService = new ProductServiceImpl(productRepository);
        ProductView productView = new ProductView(productService, moneyService);

        productRepository.add(new Product("Mie Sedap Goreng", 5000, 60));
        productRepository.add(new Product("Mie Sedap Rebus", 10000, 60));
        productRepository.add(new Product("Pepsodent", 10000, 60));

        productView.showProducts();

    }

    public static void testAddProducts() {

        // Money
        MoneyRepository moneyRepository = new MoneyRepositoryImpl();
        MoneyService moneyService = new MoneyServiceImpl(moneyRepository);
        ProductRepository productRepository = new ProductRepositoryImpl();
        ProductService productService = new ProductServiceImpl(productRepository);
        ProductView productView = new ProductView(productService, moneyService);

        productView.addProduct();
        productService.showProducts();
        productView.addProduct();
        productService.showProducts();

    }

    public static void testRemoveProducts() {

        // Money
        MoneyRepository moneyRepository = new MoneyRepositoryImpl();
        MoneyService moneyService = new MoneyServiceImpl(moneyRepository);
        ProductRepository productRepository = new ProductRepositoryImpl();
        ProductService productService = new ProductServiceImpl(productRepository);
        ProductView productView = new ProductView(productService, moneyService);

        productRepository.add(new Product("Mie Sedap Goreng", 5000, 60));
        productRepository.add(new Product("Mie Sedap Rebus", 10000, 60));
        productRepository.add(new Product("Pepsodent", 10000, 60));

        productService.showProducts();

        productView.removeProduct();

    }

}
