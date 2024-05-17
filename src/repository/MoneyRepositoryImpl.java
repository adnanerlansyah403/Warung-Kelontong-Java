package repository;

import entity.Money;

public class MoneyRepositoryImpl implements MoneyRepository {

    private Money money = new Money(0);

    public int getMoney() {
        return money.getMoney();
    }

    @Override
    public void addMoney(Integer number) {
        money.setMoney(number);
    }

    public void addMoney(Double number) {
        money.setMoney(number);
    }

    public boolean reduceMoney(Integer amount) {
        if (money.getMoney() >= amount) {
            money.setMoney(money.getMoney() - amount);
            return true;
        }
        return false;
    }

}
