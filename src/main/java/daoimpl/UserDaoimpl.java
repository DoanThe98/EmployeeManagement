package daoimpl;


import dao.UserDAO;
import model.User;
import utils.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoimpl implements UserDAO {
    @Override
    public User getUserByEmailAndPassword(String email, String pass) {
        try {
//            Connection conn = DriverManager.getConnection(dbURL,"root","kit@2022A");
            DBConnection dbc = new DBConnection();
            dbc.connectDB();
            String sql = "select * from user where email = ? AND password = ?";
            PreparedStatement ps = dbc.getConn().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setEmail(rs.getString("email"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                dbc.disconnectDB();
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
