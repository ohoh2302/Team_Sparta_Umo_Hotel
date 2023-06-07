import java.util.Scanner;

public class Main {
    private static HotelInformation hotelInform = new HotelInformation();

    public static void main(String[] args) {

        mainDisplayHandle();
    }

    public static void mainDisplayHandle() {
        Scanner sc = new Scanner(System.in);
        getMainDisplay();

        while (true) {
            int choiceNum = sc.nextInt();
            switch (choiceNum) {
                case 1:
                    getHotelDisplay();
                    break;
                case 2:
                    getCustomerDisplay();
                    break;
                case 3:
                    exitKiosk();
                    break;
            }
        }
    }

    public static void hotelDisplayHandle() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int choiceNum = sc.nextInt();
            switch (choiceNum) {
                case 1:
                    hotelInform.호텔예약목록();
                    break;
                case 2:
//                    hotelInform.호텔자산();
                    break;
                default:
                    System.out.println("[Error]");
                    System.out.println("초기화면으로 돌아갑니다.");
                    mainDisplayHandle();
                    break;
            }
        }
    }

    public static void customerDisplayHandle() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int choiceNum = sc.nextInt();
            switch (choiceNum) {
                case 1:
                    hotelInform.customerRoom();
                    break;
                case 2:
                    hotelInform.insertCustomerInformation();
                    break;
                case 3:
//                    hotelInform.고객예약취소();
                    break;
                case 4:
//                    hotelInform.고객예약목록();
                    break;
                default:
                    System.out.println("[Error]");
                    System.out.println("초기화면으로 돌아갑니다.");
                    mainDisplayHandle();
                    break;
            }
        }
    }


    private static void getMainDisplay() {
        System.out.println("[우모호텔]");
        System.out.println("1.호텔");
        System.out.println("2.고객");
        System.out.println("3.퇴근");
    }

    private static void getCustomerDisplay() {
        System.out.println("[고객]");
        System.out.println("1.객실정보");
        System.out.println("2.객실예약");
        System.out.println("3.예약취소");
        System.out.println("4.예약목록");

        customerDisplayHandle();
    }

    private static void getHotelDisplay() {
        System.out.println("[호텔]");
        System.out.println("1.예약목록");
        System.out.println("2.자산");

        hotelDisplayHandle();
    }

    private static void exitKiosk() {
        System.out.println("이용해주셔서 감사합니다.");;
        System.exit(0);
    }
}