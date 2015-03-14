package dao.user;

import dao.DAOFactory;
import valueobject.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Den on 11.03.2015.
 */
public class UserDAO implements IUserDAO {

    @Override
    public void addUser(User user) { }

    @Override
    public boolean updateUser(User user) {
        return true;
    }

    @Override
    public boolean verifyUserByEmail(String email) {

        Connection con = DAOFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean hasRow = false;

        try {
            st = con.prepareStatement("SELECT id FROM user WHERE email = ?");
            st.setString(1,email);
            rs = st.executeQuery();
            hasRow = rs.next();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
                try {
                    if(st != null) st.close();
                    if(rs != null) rs.close();
                    if(con != null) con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return hasRow;
    }

    @Override
    public User getUserByEmail(String email) {

        Connection con = DAOFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        User user = null;

        try {
            st = con.prepareStatement("SELECT id,name,surname,email,password FROM user WHERE email = ?");
            st.setString(1,email);
            rs = st.executeQuery();

            while (rs.next()){
                user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSurname(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setPassword(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if(st != null) st.close();
                if(rs != null) rs.close();
                if(con != null) con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

}
