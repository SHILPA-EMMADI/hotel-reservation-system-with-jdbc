package model;

public class Room {
    private int roomId, roomNumber;
    private String roomType, status;
    private double pricePerNight;

    public Room() {}
    public Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber; this.roomType = roomType; this.pricePerNight = pricePerNight; this.status = "AVAILABLE";
    }
    public Room(int roomId, int roomNumber, String roomType, double pricePerNight, String status) {
        this.roomId = roomId; this.roomNumber = roomNumber; this.roomType = roomType; this.pricePerNight = pricePerNight; this.status = status;
    }
    public int getRoomId(){return roomId;} public int getRoomNumber(){return roomNumber;} public String getRoomType(){return roomType;} public double getPricePerNight(){return pricePerNight;} public String getStatus(){return status;}
    public void setRoomId(int v){roomId=v;} public void setRoomNumber(int v){roomNumber=v;} public void setRoomType(String v){roomType=v;} public void setPricePerNight(double v){pricePerNight=v;} public void setStatus(String v){status=v;}
}
