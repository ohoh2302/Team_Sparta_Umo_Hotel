public class Hotel {
    private int size;
    private int price;
    private boolean reserve;
    private String reserveNumber;
    private String date;
    public Hotel(int size, int price, boolean reserve) {
        this.size = size;
        this.price = price;
        this.reserve = reserve;
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
}
