package model;

import java.time.LocalDate;

public class Reservation {
    private int reservationId, guestId, roomId;
    private LocalDate checkIn, checkOut;
    private String status;
    public Reservation() {}
    public Reservation(int guestId,int roomId,LocalDate checkIn,LocalDate checkOut){this.guestId=guestId;this.roomId=roomId;this.checkIn=checkIn;this.checkOut=checkOut;this.status="BOOKED";}
    public int getReservationId(){return reservationId;} public int getGuestId(){return guestId;} public int getRoomId(){return roomId;} public LocalDate getCheckIn(){return checkIn;} public LocalDate getCheckOut(){return checkOut;} public String getStatus(){return status;}
    public void setReservationId(int v){reservationId=v;} public void setGuestId(int v){guestId=v;} public void setRoomId(int v){roomId=v;} public void setCheckIn(LocalDate v){checkIn=v;} public void setCheckOut(LocalDate v){checkOut=v;} public void setStatus(String v){status=v;}
}
