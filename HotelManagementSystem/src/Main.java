import model.*;
import service.ReservationService;
import util.InputValidator;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){Scanner sc=new Scanner(System.in);ReservationService service=new ReservationService();while(true){System.out.println("\n===== HOTEL MANAGEMENT SYSTEM =====");System.out.println("1.Add Room\n2.View Rooms\n3.Search Available Rooms\n4.Reserve Room\n5.View Reservations\n6.View Reservation\n7.Check-in\n8.Check-out + Bill\n9.Update Reservation\n10.Cancel Reservation\n11.Revenue Report\n0.Exit");int c=InputValidator.readInt(sc,"Enter choice: ");try{switch(c){case 1->addRoom(sc,service);case 2->viewRooms(service);case 3->available(sc,service);case 4->reserve(sc,service);case 5->service.viewAllReservations();case 6->viewOne(sc,service);case 7->checkIn(sc,service);case 8->checkout(sc,service);case 9->update(sc,service);case 10->cancel(sc,service);case 11->service.revenueReport();case 0->{System.out.println("Thank you!");return;}default->System.out.println("Invalid choice!");}}catch(SQLException|IllegalArgumentException e){System.out.println("Error: "+e.getMessage());}}}
    static void addRoom(Scanner s,ReservationService x)throws SQLException{x.addRoom(new Room(InputValidator.readInt(s,"Room number: "),InputValidator.readString(s,"Room type: "),InputValidator.readDouble(s,"Price/night: ")));System.out.println("Room added!");}
    static void viewRooms(ReservationService x)throws SQLException{for(Room r:x.getAllRooms())System.out.printf("Room %d | %s | ₹%.2f | %s%n",r.getRoomNumber(),r.getRoomType(),r.getPricePerNight(),r.getStatus());}
    static void available(Scanner s,ReservationService x)throws SQLException{LocalDate i=InputValidator.readDate(s,"Check-in: "),o=InputValidator.readDate(s,"Check-out: ");for(Room r:x.getAvailableRooms(i,o))System.out.printf("Room %d | %s | ₹%.2f%n",r.getRoomNumber(),r.getRoomType(),r.getPricePerNight());}
    static void reserve(Scanner s,ReservationService x)throws SQLException{Guest g=new Guest(InputValidator.readString(s,"Guest name: "),InputValidator.readString(s,"Contact: "),InputValidator.readString(s,"Email: "));int n=InputValidator.readInt(s,"Room number: ");LocalDate i=InputValidator.readDate(s,"Check-in: "),o=InputValidator.readDate(s,"Check-out: ");System.out.println("Reservation ID: "+x.bookRoom(g,n,i,o));}
    static void viewOne(Scanner s,ReservationService x)throws SQLException{Reservation r=x.findReservation(InputValidator.readInt(s,"Reservation ID: "));System.out.println(r==null?"Not found!":"ID: "+r.getReservationId()+" | Room ID: "+r.getRoomId()+" | "+r.getCheckIn()+" to "+r.getCheckOut()+" | "+r.getStatus());}
    static void checkIn(Scanner s,ReservationService x)throws SQLException{System.out.println(x.checkIn(InputValidator.readInt(s,"Reservation ID: "))?"Checked in!":"Check-in failed!");}
    static void checkout(Scanner s,ReservationService x)throws SQLException{x.checkOutAndGenerateBill(InputValidator.readInt(s,"Reservation ID: "));}
    static void update(Scanner s,ReservationService x)throws SQLException{int id=InputValidator.readInt(s,"Reservation ID: ");LocalDate i=InputValidator.readDate(s,"New check-in: "),o=InputValidator.readDate(s,"New check-out: ");System.out.println(x.updateReservation(id,i,o)?"Updated!":"Update failed!");}
    static void cancel(Scanner s,ReservationService x)throws SQLException{System.out.println(x.cancelReservation(InputValidator.readInt(s,"Reservation ID: "))?"Cancelled!":"Cancel failed!");}
}
