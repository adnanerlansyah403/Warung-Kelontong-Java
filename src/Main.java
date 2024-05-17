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

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Money
        MoneyRepository moneyRepository = new MoneyRepositoryImpl();
        MoneyService moneyService = new MoneyServiceImpl(moneyRepository);
        MoneyView moneyView = new MoneyView(moneyService);

        // Product
        ProductRepository productRepository = new ProductRepositoryImpl();
        ProductService productService = new ProductServiceImpl(productRepository);
        ProductView productView = new ProductView(productService, moneyService);

        boolean isSuccess = moneyView.saveMoney();
        if(isSuccess) productView.showProducts();
    }
}