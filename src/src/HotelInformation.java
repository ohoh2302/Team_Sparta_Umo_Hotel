import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HotelInformation {
    Scanner sc = new Scanner(System.in);

    //객실 정보 저장 리스트
    private List<Hotel> hotels;

    // 고객 데이터 리스트
    private List<Customer> customers;

    // 예약 데이터
    private List<ReserveData> reserveData;

    // 예약 번호 생성에 필요한 hotel 을 불러옴
    Hotel hotel = new Hotel();

    public HotelInformation() {
        hotels = new ArrayList<>();
        customers = new ArrayList<>();
        reserveData = new ArrayList<>();
        //HotelInformation 객체를 생성할때 호텔 객실 데이터 생성 후 저장
        hotels.add(new Hotel(1, 29, 40000, false));
        hotels.add(new Hotel(2, 32, 50000, false));
        hotels.add(new Hotel(3, 40, 70000, false));

    }

    public void hotelReservationCheck() {
        System.out.println("호텔예약목록");
        System.out.printf("%-4s   %-16s   %-16s   %-20s \n", "Num", "Date", "Phone", "예약자");
        for (int i = 0; i < reserveData.size(); i++) {
            ReserveData rd = reserveData.get(i);
            System.out.printf
                    ("%-4d | %-16s | %-16s | %-20s  \n",
                            rd.getHotelNumber(),
                            rd.getDate(),
                            rd.getPhone(),
                            rd.getName()
                    );
        }
        Main.mainDisplayHandle();
    }

    public void hotelProperty() {
        int sum = 0;
        System.out.println("호텔자산");
        for (int i = 0; i < reserveData.size(); i++) {
            ReserveData rd = reserveData.get(i);
            sum += rd.getPrice();
        }
        System.out.println("금액 : " + sum);
        Main.mainDisplayHandle();
    }

    //객실 정보 조회
    public void getCustomerRoom() {
        customerRoom();
        System.out.println("1. 예약하기  2. 돌아가기");
        int number = sc.nextInt();
        sc.nextLine();
        if(number == 1){
            setCustomerInformation();
        }else{
            Main.mainDisplayHandle();
        }
    }

    public void customerRoom() {
        System.out.println("고객객실정보");

        for (int i = 0; i < hotels.size(); i++) {
            System.out.println(hotels.get(i).getHotelNumber() + ". | " + hotels.get(i).getSize() + " | " + hotels.get(i).getPrice()
                    + " | " + hotels.get(i).getReserve());
        }

    }

    // 데이터 입력시 형식에 맞는지 확인
    public String chekMatche(String name, String formData,String comment){
        boolean result =  name.matches(formData);
        if(!result){
            //위와같은 형식이 아니라면
            System.out.println(comment);
            System.out.println("다시 입력해 주세요");
            String otherName = sc.nextLine();
            //제귀
            return chekMatche(otherName, formData, comment);
        }
        return name;
    }

    // 고갱 정보 입력
    public void setCustomerInformation() {
        //name phone money 를 차례로 입력받는다
        // 3개의 값을 메치로 검사한다.
        // 검사중 다른점이 있으면 다시 적게하기
        String formData; // 형식데이터
        boolean result; // 형식이 맞는지 확인하는 true/false
        String comment; // 맨트
        comment = "한글만 입력하셔야 합니다";
        System.out.println("사용자 이름을 입력하세요.("+comment+")");

        formData = "^[가-힣]*$";
        String name = chekMatche(sc.nextLine(), formData, comment);
        System.out.println("사용자 전화번호를 입력하세요.");

        comment = "xxx-xxxx-xxxx 형태로,  - 와같이 입력해 주세요.";
        System.out.println(comment);

        formData = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
        String phone = chekMatche(sc.nextLine(), formData, comment);
        comment = "숫자만입력해 주세요";
        System.out.println("사용자 자금을 입력하세요.("+comment+")");

        formData = "^[0-9]*$";
        String money = chekMatche(sc.nextLine(), formData, comment);

        // 객실 정보 출력
        customerRoom();

        comment = "객실을 선택하세요. (정해진 번호만 입력하세요)";
        System.out.println(comment);

        String roomSize = String.valueOf(hotels.size());
        formData = "[1-"+roomSize+"]";

        // 객실과 다른 번호를 입력했을시 다시 입력
        int roomNumber = Integer.parseInt(chekMatche(sc.nextLine(), formData, comment))-1;

        //객실이 예약이 되어있는지 확인
        if (!hotels.get(roomNumber).getReserve()) {
            //예약이 안되어있을경우

            // 객실에 정해진 가격보다 작으면 예약 불가하게 하기
            if (checkPrice(roomNumber, Integer.parseInt(money))) {
                // 데이터 생성해주거나 맞춰주는 함수 생성
                createList(roomNumber, name, phone);
            } else {
                System.out.println("카드 잔액을 확인하세요");
                Main.mainDisplayHandle();
            }

        } else {
            //예약이 되어 있는경우
            System.out.println("이미 예약된 객실입니다.");
            Main.mainDisplayHandle();
        }

    }

    //가격이 되는지
    private boolean checkPrice(int roomNumber, int money) {

        if (money >= hotels.get(roomNumber).getPrice()) {
            return true;
        } else {
            return false;
        }

    }

    //예약 데이터 생성
    private void createList(int roomNumber, String name, String phone) {

        //예약번호 생성
        String reserveNumber = hotel.setReserveNumber();

        //날짜 생성
        LocalDateTime localDateTime = LocalDateTime.now();

        String localDateTimeFormat
                = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm"));

        // 이름 번호 방번호 예약번호 날짜 가격 --------등 을 리스트로 생성
        reserveData.add(new ReserveData(name, phone, hotels.get(roomNumber).getHotelNumber()
                , hotels.get(roomNumber).getSize(), hotels.get(roomNumber).getPrice(), reserveNumber, localDateTimeFormat));

        //리스트를 방번호순으로 정렬
        Collections.sort(reserveData, new ReserveData());

        System.out.println("예약이 완료 되었습니다.");
        System.out.println(name +"님의 예약 내용입니다");
        //객실 사이즈 가격 예약번호
        System.out.printf("%10s | %4s | %5s | %13s ","RoomNumber", "Size", "Price" ,"ReserveNumber");
        System.out.println();

        for(int i = 0; i<reserveData.size();i++){
            if(phone.equals(reserveData.get(i).getPhone())) {
                System.out.printf("%10d | %4d | %5d | %13s ", reserveData.get(i).getHotelNumber(), reserveData.get(i).getSize(),
                        reserveData.get(i).getPrice(),reserveData.get(i).getReserveNumber());
                System.out.println();
            }
        }

        // 객실 정보 true 변경 함수
        reserveComplete(roomNumber);

        Main.mainDisplayHandle();
    }

    private void reserveComplete(int roomNumber) {
        hotels.get(roomNumber).setReserve(true);
    }


    // 객실 번호 입력 받기
    public void customerCancelCheck() {
        Scanner sc = new Scanner(System.in);
        System.out.println("객실 번호를 입력하세요");
        int roomNum = sc.nextInt();
        sc.nextLine();

        System.out.println("예약 번호를 입력하세요");
        String reserveNum = sc.nextLine();

        cancelReserve(roomNum, reserveNum);


    }

    private void cancelReserve(int roomNumber, String reserveNum) {
        for (int i = 0; i < reserveData.size(); i++) {
            if (reserveData.get(i).getReserveNumber().equals(reserveNum)
                    && roomNumber == reserveData.get(i).getHotelNumber()) { // 객실번호와 예약번호가 맞아야 취소
                reserveCancel(roomNumber);// 취소하면 false로 다시 바꾸기
                reserveData.remove(i);
                System.out.println("취소 완료");
                Main.mainDisplayHandle();

            }
        }

        System.out.println("일치하는 정보가 없습니다.");
        Scanner sc = new Scanner(System.in);
        System.out.println("1.계속 진행하시겠습니까?  2. 메뉴로 돌아가시겠습니까?");
        int selectNum = sc.nextInt();

        if(selectNum == 1){
        customerCancelCheck();} // 1번 입력 한다면 다시 입력란으로 돌아가는 재귀함수
        else if (selectNum == 2) {
            Main.mainDisplayHandle(); // 2번 입력 다시 메뉴로 돌아가기

        }else System.out.println("다시 입력하세요.");

    }

        //boolean값 다시 false로 바꾸기
    private void reserveCancel(int roomNumber) {
        roomNumber--;
        hotels.get(roomNumber).setReserve(false);
    }

//    고객예약목록
    public void customerCheckList() {
        System.out.println("예약번호를 입력해주세요.");
        String reserveNum = sc.nextLine();
//            예약번호 맞는지 확인 후 목록 출력
        System.out.printf("%-4s   %-16s   %-16s   %-20s \n","Num","Date", "Phone", "예약자");
        for(int i=0; i<reserveData.size(); i++) {
            if (reserveData.get(i).getReserveNumber().equals(reserveNum)) {
                ReserveData rd = reserveData.get(i);
                System.out.printf
                        ("%-4d | %-16s | %-16s | %-20s  \n" ,
                                rd.getHotelNumber(),
                                rd.getDate(),
                                rd.getPhone(),
                                rd.getName()
                        );
            }
        } Main.mainDisplayHandle();
    }

    public List<Hotel> getHotels(){
        return hotels;
    }

    public List<Customer> customers(){
        return customers;
    }


}


