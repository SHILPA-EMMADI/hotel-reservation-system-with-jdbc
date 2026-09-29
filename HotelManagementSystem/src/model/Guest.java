package model;

public class Guest {
    private int guestId;
    private String guestName, contactNo, email;
    public Guest() {}
    public Guest(String guestName, String contactNo, String email) { this.guestName=guestName; this.contactNo=contactNo; this.email=email; }
    public int getGuestId(){return guestId;} public String getGuestName(){return guestName;} public String getContactNo(){return contactNo;} public String getEmail(){return email;}
    public void setGuestId(int v){guestId=v;} public void setGuestName(String v){guestName=v;} public void setContactNo(String v){contactNo=v;} public void setEmail(String v){email=v;}
}
