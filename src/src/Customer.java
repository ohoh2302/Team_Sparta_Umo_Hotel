public class Customer {
    private String name;
    private String phone;
    private int money;
    public Customer(String name, String phone, int money ) {
        this.name = name;
        this.phone = phone;
        this.money = money;
    }

    public String getName(){
        return name;

    }

    public String getPhone(){
        return phone;
    }

    public int getMoney(){
        return money;
    }

}
