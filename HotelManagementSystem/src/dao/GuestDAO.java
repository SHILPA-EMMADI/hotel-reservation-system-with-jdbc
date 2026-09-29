package dao;

import config.DBConnection;
import model.Guest;
import java.sql.*;

public class GuestDAO {
    public int addGuest(Guest g) throws SQLException {String sql="INSERT INTO guests (guest_name, contact_no, email) VALUES (?, ?, ?)";try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){p.setString(1,g.getGuestName());p.setString(2,g.getContactNo());p.setString(3,g.getEmail());p.executeUpdate();try(ResultSet r=p.getGeneratedKeys()){return r.next()?r.getInt(1):-1;}}}
}
