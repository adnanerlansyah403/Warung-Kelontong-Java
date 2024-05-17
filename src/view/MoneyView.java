package view;

import service.MoneyService;
import util.InputUtil;

public class MoneyView {

    private MoneyService moneyService;

    public MoneyView(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

    public boolean saveMoney() {
        System.out.println("Masukkan jumlah uang yang tersedia");

        while(true) {

            var moneyStr = InputUtil.input("Masukkan jumlah uang (Tekan x jika batal)");
            if (moneyStr.equals("x")) {
                System.out.println("Maaf anda tidak bisa melakukan tranksaksi jika jumlah uang tidak di masukkan");
                return false;
            }

            int money;
            try {
                money = Integer.parseInt(moneyStr);
            } catch (NumberFormatException e) {
                System.out.println("Data jumlah uang di masukkan tidak valid.");
                continue;
            }

            if(money < 0) {
                System.out.println("Jumlah uang tidak boleh 0");
                continue;
            }

            moneyService.addMoney(money);
            return true;
        }
    }

}
