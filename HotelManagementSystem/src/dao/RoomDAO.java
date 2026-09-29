package dao;

import config.DBConnection;
import model.Room;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    public boolean addRoom(Room room) throws SQLException {
        String sql="INSERT INTO rooms (room_number, room_type, price_per_night) VALUES (?, ?, ?)";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){p.setInt(1,room.getRoomNumber());p.setString(2,room.getRoomType());p.setDouble(3,room.getPricePerNight());return p.executeUpdate()>0;}
    }
    public List<Room> getAllRooms() throws SQLException {
        List<Room> list=new ArrayList<>(); String sql="SELECT * FROM rooms ORDER BY room_number";
        try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(sql);ResultSet r=p.executeQuery()){while(r.next())list.add(map(r));} return list;
    }
    public Room findByRoomNumber(int n) throws SQLException {String sql="SELECT * FROM rooms WHERE room_number=?";try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(sql)){p.setInt(1,n);try(ResultSet r=p.executeQuery()){return r.next()?map(r):null;}}}
    public List<Room> findAvailableRooms(LocalDate in,LocalDate out) throws SQLException {List<Room> list=new ArrayList<>();String sql="SELECT * FROM rooms r WHERE r.status='AVAILABLE' AND NOT EXISTS (SELECT 1 FROM reservations x WHERE x.room_id=r.room_id AND x.status IN ('BOOKED','CHECKED_IN') AND x.check_in < ? AND x.check_out > ?) ORDER BY r.room_number";try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(sql)){p.setDate(1,Date.valueOf(out));p.setDate(2,Date.valueOf(in));try(ResultSet r=p.executeQuery()){while(r.next())list.add(map(r));}}return list;}
    private Room map(ResultSet r)throws SQLException{return new Room(r.getInt("room_id"),r.getInt("room_number"),r.getString("room_type"),r.getDouble("price_per_night"),r.getString("status"));}
}
