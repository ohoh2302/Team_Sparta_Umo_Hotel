import javax.swing.plaf.PanelUI;

public class Hotel {
    //방을 특정할 수 있는 번호
    private int hotelNumber;
    private int size; // 방크기
    private int price; // 가격
    private boolean reserve; // 예약 여부
    private int reserveNumber = 100; // 예약번호
    private String date; // 날자

    public Hotel(){

    }
    public Hotel(int hotelNumber, int size, int price, boolean reserve) {
        this.hotelNumber = hotelNumber;
        this.size = size;
        this.price = price;
        this.reserve = reserve;
    }
    public int getHotelNumber(){
        return hotelNumber;
    }
    public int getSize(){
        return size;
    }

    public int getPrice() {
        return price;
    }

    public boolean getReserve() {
        return reserve;
    }


  public void setReserve(boolean reserve) {
        this.reserve = reserve;
    }

    public int setReserveNumber(){
        ++reserveNumber;
        return reserveNumber;
    }

}
