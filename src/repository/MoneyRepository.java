package repository;

public interface MoneyRepository {

    int getMoney();

    void addMoney(Integer number);

    boolean reduceMoney(Integer amount);

}
