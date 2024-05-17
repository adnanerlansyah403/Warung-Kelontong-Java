package entity;

public class Money {

    private Integer money = 0;

    public Money(Integer money) {
        this.money = money;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = Integer.parseInt(String.valueOf(money));
    }

    public void setMoney(Integer money) {
        this.money = money;
    }


}
