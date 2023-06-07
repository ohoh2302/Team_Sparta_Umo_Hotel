import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelInformation {
    Scanner sc =new Scanner(System.in);

    //객실 정보 저장 리스트
    private ArrayList<Hotel> hotels = new ArrayList<>();

    // 고객 데이터 리스트
    private ArrayList<Customer>  customers = new ArrayList<>();

    // 예약 데이터
    private ArrayList<ReserveData>  reserveData = new ArrayList<>();

    // 예약 번호 생성에 필요한 hotel 을 불러옴
    Hotel hotel = new Hotel();
    public HotelInformation() {
        //HotelInformation 객체를 생성할때 호텔 객실 데이터 생성 후 저장
        hotels.add(new Hotel(1,29,40000,false));
        hotels.add(new Hotel(2, 32,50000,false));
        hotels.add(new Hotel(3, 40,70000,false));

    }

    public void 호텔예약목록() {
        System.out.println("호텔예약목록"); //hotelReservationCheck
            for(int i = 0; i< reserveData.size();i++){
        ReserveData rd = reserveData.get(i);
        System.out.println
                (
                        rd.getHotelNumber() + " | " +
                        rd.getName() + " | " +
                        rd.getPhone() + " | " +
                        rd.getDate());
    }
        Main.mainDisplayHandle();
    }

//    public void 호텔자산() {
//        System.out.println("호텔자산");
//        Main.mainDisplayHandle();
//    }

    public void customerRoom() {
        System.out.println("고객객실정보");


        for(int i = 0; i< hotels.size();i++){
            System.out.println(hotels.get(i).getHotelNumber() + ". | " + hotels.get(i).getSize()+ " | " + hotels.get(i).getPrice()
                    + " | " + hotels.get(i).getReserve());
        }

    }

    // 고갱 정보 입력
    public void insertCustomerInformation() {

        System.out.println("사용자 이름을 입력하세요");
        String name = sc.nextLine();

        System.out.println("사용자 전화번호를 입력하세요");
        String phone = sc.nextLine();

        System.out.println("사용자 자금을 입력하세요");
        int money = sc.nextInt();

        // 사용자가 입력한 데이터를 이용해 고객 리스트 생성
//        customers.add(new Customer(name, phone, money));

//        System.out.println("customers.size()"+customers.size());
//        for(int i =0; i<customers.size();i++){
//            System.out.println(customers.get(i).getName() + customers.get(i).getPhone() + customers.get(i).getMoney());
//        }

        // 객실 정보 출력
        customerRoom();

        System.out.println("객실을 선택하세요");
        int roomNumber = sc.nextInt()-1;
        sc.nextLine();
        //객실이 예약이 되어있는지 확인
        if(!hotels.get(roomNumber).getReserve()){
            //예약이 안되어있을경우

            // 객실에 정해진 가격보다 작으면 예약 불가하게 하기
            if(checkPrice(roomNumber, money)){
                // 데이터 생성해주거나 맞춰주는 함수 생성
                createList(roomNumber,name,phone);
            }else {
                System.out.println("카드 잔액을 확인하세요");
                Main.mainDisplayHandle();
            }

        }else {
            //예약이 되어 있는경우
            System.out.println("이미 예약된 객실입니다.");
            Main.mainDisplayHandle();
        }

    }

    //가격이 되는지
    private boolean checkPrice(int roomNumber, int money) {

        if(money >= hotels.get(roomNumber).getPrice()){
            return true;
        }else {
            return false;
        }

    }

    //예약 데이터 생성
    private void createList(int roomNumber,String name, String phone) {

        //예약번호 생성
        int reserveNumber = hotel.setReserveNumber();

        //날짜 생성
        LocalDateTime localDateTime = LocalDateTime.now();

        String localDateTimeFormat
                = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm"));

        // 이름 번호 방번호 예약번호 날짜 가격 --------등 을 리스트로 생성
        reserveData.add(new ReserveData(name, phone, hotels.get(roomNumber).getHotelNumber()
                , hotels.get(roomNumber).getSize(),hotels.get(roomNumber).getPrice(), reserveNumber , localDateTimeFormat));



        System.out.println("reserveData.size()"+reserveData.size());
        for(int i =0; i<reserveData.size();i++){
            System.out.println(reserveData.get(i).getName() + reserveData.get(i).getPhone() + "number" + reserveData.get(i).getHotelNumber() + " size" + reserveData.get(i).getSize()
                    + " price " + reserveData.get(i).getPrice() + reserveData.get(i).getReserveNumber() + reserveData.get(i).getDate());
        }

        System.out.println("예약이 완료 되었습니다.");

        // 객실 정보 true 변경 함수
        reserveComplete(roomNumber);

        Main.mainDisplayHandle();
    }

    private void reserveComplete(int roomNumber) {
        hotels.get(roomNumber).setReserve(true);
    }

//    public void 고객예약취소() {
//        System.out.println("고객예약취소");
//        Main.mainDisplayHandle();
//    }

//    public void 고객예약목록() {
//        System.out.println("고객예약목록");
//        Main.mainDisplayHandle();
//    }

    public ArrayList<Hotel> getHotels(){
        return hotels;
    }

    public ArrayList<Customer> customers(){
        return customers;
    }


}


