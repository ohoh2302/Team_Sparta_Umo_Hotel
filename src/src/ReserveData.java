public class ReserveData {
    private String name;
    private String phone;
    private int hotelNumber;
    private int size; // 방크기
    private int price; // 가격
    private String reserveNumber; // 예약번호
    private String date; // 예약 날짜

    public ReserveData(String name, String phone, int hotelNumber, int size, int price ,String reserveNumber, String date){
        this.name = name;
        this.phone = phone;
        this.hotelNumber = hotelNumber;
        this.size = size;
        this.price = price;
        this.reserveNumber = reserveNumber;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getHotelNumber() {
        return hotelNumber;
    }

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public String getReserveNumber() {
        return reserveNumber;
    }
    public String getDate(){
        return date;
    }
}
