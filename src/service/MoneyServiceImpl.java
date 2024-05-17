package service;

import repository.MoneyRepository;

public class MoneyServiceImpl implements MoneyService{

    private MoneyRepository moneyRepository;

    public MoneyServiceImpl(MoneyRepository moneyRepository) {
        this.moneyRepository = moneyRepository;
    }

    @Override
    public void showMoney() {
        System.out.println("Your money is : " + moneyRepository.getMoney());
    }

    @Override
    public int getMoney() {
        return moneyRepository.getMoney();
    }

    @Override
    public void addMoney(Integer number) {
        moneyRepository.addMoney(number);
        System.out.println("Sukses memasukkan data jumlah uang");
    }

    @Override
    public void reduceMoney(Integer number) {
        boolean success = moneyRepository.reduceMoney(number);
        if(success) System.out.println("Uang anda telah di kurang sebanyak : " + number);
        else System.out.println("Gagal melakukan pengurangan pada uang");
    }
}
