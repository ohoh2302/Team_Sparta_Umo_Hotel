public class Customer {
    private String name;
    private String phone;
    private int money;
    private int hotelNumber = 0;
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

    // 예약 완료시 고객 호텔 번호 변경
    public void setHotelNumber(int hotelNumber){
        this.hotelNumber = hotelNumber;
    }
}
