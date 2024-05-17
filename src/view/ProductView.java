package view;

import entity.Money;
import entity.Product;
import service.MoneyService;
import service.ProductService;
import util.InputUtil;

public class ProductView {

    private ProductService productService;
    private MoneyService moneyService;

    public ProductView(ProductService productService, MoneyService moneyService) {
        this.productService = productService;
        this.moneyService = moneyService;
    }

    public void showProducts() {
        while(true) {
            System.out.println("My money " + "(" + moneyService.getMoney() + ")");
            System.out.println("List Products: ");
            productService.showProducts();

            System.out.println("MENU: ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            if(productService.getProductSize() > 0) System.out.println("3. Beli");
            System.out.println("x. Keluar");

            var input = InputUtil.input("Pilih Menu");

            if(input.equals("1")) {
                addProduct();
            } else if (input.equals("2")) {
                removeProduct();
            } else if (input.equals("3")) {
                buyProduct();
                if (moneyService.getMoney() == 0) {
                    break;
                }
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak di mengerti, silahkan pilih yang sesuai dari menu");
            }
        }
    }

    public void addProduct() {
        System.out.println("Menambah Product");

        while (true) {
            var productName = InputUtil.input("Product name (Tekan x jika batal)");

            if (productName.equals("x")) {
                System.out.println("Pembatalan. Tidak ada produk yang ditambahkan.");
                break;
            }

            // Validasi input
            if (productName.trim().isEmpty()) {
                System.out.println("Nama produk tidak boleh kosong.");
                continue;
            }

            // Menambahkan produk
            var productPriceStr = InputUtil.input("Product price (Tekan x jika batal)");
            if (productPriceStr.equals("x")) {
                System.out.println("Pembatalan. Tidak ada produk yang ditambahkan.");
                break;
            }

            // Validasi harga
            int productPrice;
            try {
                productPrice = Integer.parseInt(productPriceStr);
            } catch (NumberFormatException e) {
                System.out.println("Harga produk tidak valid. Masukkan angka yang valid.");
                continue;
            }

            if (productPrice <= 0) {
                System.out.println("Harga produk harus lebih dari nol.");
                continue;
            }

            // Validasi quantity
            var productQuantityStr = InputUtil.input("Product quantity (Tekan x jika batal)");
            if (productQuantityStr.equals("x")) {
                System.out.println("Pembatalan. Tidak ada produk yang ditambahkan.");
                break;
            }

            int productQuantity;
            try {
                productQuantity = Integer.parseInt(productQuantityStr);
            } catch (NumberFormatException e) {
                System.out.println("Jumlah quantity dari product tidak valid.");
                continue;
            }

            if (productQuantity <= 0) {
                System.out.println("Jumlah dari product tidak boleh 0.");
                continue;
            }

            // Jika semua validasi berhasil, tambahkan produk
            productService.addProduct(new Product(productName, productPrice, productQuantity));
            System.out.println("Produk berhasil ditambahkan.");
            break;
        }
    }

    public void removeProduct() {
        System.out.println("Menghapus Product");

        while (true) {
            var number = InputUtil.input("Product number (Tekan x jika batal)");

            if (number.equals("x")) {
                System.out.println("Pembatalan. Tidak ada Product yang dihapus.");
                break;
            }

            // Validasi input
            try {
                int productNumber = Integer.parseInt(number);
                if (productNumber < 1 || productNumber > productService.getProductSize()) {
                    System.out.println("Nomor Product tidak valid.");
                    continue;
                }

                // Menghapus Todolist
                productService.removeProduct(productNumber);
                System.out.println("Product berhasil dihapus.");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan nomor Product yang valid atau 'x' untuk membatalkan.");
            }
        }
    }

    public void buyProduct() {
        while(true) {
            System.out.println("My money: " + moneyService.getMoney());
            System.out.println("Daftar Produk (Warung Kelontong):");
            productService.showProducts();

            // Meminta input nama produk
            var productName = askNameProduct();
            if (productName.equals("x")) {
                System.out.println("Pembatalan. Tidak ada produk yang dibeli.");
                break;
            }

            // Validasi apakah produk tersedia
            Product product = productService.findProductByName(productName);
            if (product == null) {
                System.out.println("Produk tidak ditemukan.");
                askNameProduct();
            }

            // Meminta input kuantitas produk
            var productQuantityStr = askQuantityProduct();
            if (productQuantityStr.equals("x")) {
                System.out.println("Pembatalan. Tidak ada produk yang dibeli.");
                break;
            }

            int productQuantity = 0;
            try {
                productQuantity = Integer.parseInt(productQuantityStr);
            } catch (NumberFormatException e) {
                System.out.println("Jumlah produk tidak valid.");
                askQuantityProduct();
            }

            if (productQuantity <= 0) {
                System.out.println("Jumlah produk tidak boleh 0 atau negatif.");
                askQuantityProduct();
            }

            // Menghitung total harga
            int totalPrice = product.getPrice() * productQuantity;

            // Memeriksa apakah uang cukup
            if (moneyService.getMoney() < totalPrice) {
                System.out.println("Uang tidak cukup untuk membeli produk ini.");
                continue;
            }

            // Proses pembelian
            moneyService.reduceMoney(totalPrice);
            productService.reduceProductStock(productName, productQuantity);
            if(moneyService.getMoney() == 0) System.out.println("Berhasil membeli product dan uang anda sudah habis");
            else System.out.println("Berhasil membeli " + productQuantity + " " + productName);
            break;
        }
    }

    public String askNameProduct() {
        return InputUtil.input("Nama produk (Tekan x jika batal)");
    }

    public String askQuantityProduct() {
        return InputUtil.input("Jumlah produk (Tekan x jika batal)");
    }

}
