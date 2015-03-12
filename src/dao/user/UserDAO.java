package dao.user;

import valueobject.User;

/**
 * Created by Den on 11.03.2015.
 */
public class UserDAO implements IUserDAO {

    @Override
    public void addUser(User user) {

    }

    @Override
    public boolean updateUser(User user) {
        return true;
    }

    @Override
    public boolean verifyUserByEmail(String email) {
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public boolean verifyUserPassword(String password) {
        return false;
    }
}
