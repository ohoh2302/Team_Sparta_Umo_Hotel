public class HotelInformation {

    private ArrayList<Hotel> hotels;
    public void HotelInformation() {

    }
//    public void 호텔예약목록() {
//        System.out.println("호텔예약목록");
//        Main.mainDisplayHandle();
//    }

    public void customerRoom() {
        hotels = new ArrayList<>();
        System.out.println("고객객실정보");
        hotels.add(new Hotel(29,40000,false));
        hotels.add(new Hotel(32,50000,false));
        hotels.add(new Hotel(40,70000,false));

        for(int i = 0; i< hotels.size();i++){
            System.out.println((i+1) + ". | " + hotels.get(i).getSize()+ " | " + hotels.get(i).getPrice()
                    + " | " + hotels.get(i).getReserve());
        }

        Main.mainDisplayHandle();
    }

//    public void 고객객실정보() {
//        System.out.println("고객객실정보");
//        Main.mainDisplayHandle();
//    }

//    public void 고객객실예약() {
//        System.out.println("고객객실예약");
//        Main.mainDisplayHandle();
//    }

//    public void 고객예약취소() {
//        System.out.println("고객예약취소");
//        Main.mainDisplayHandle();
//    }

//    public void 고객예약목록() {
//        System.out.println("고객예약목록");
//        Main.mainDisplayHandle();
//    }
}
