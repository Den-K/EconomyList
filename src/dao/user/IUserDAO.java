package dao.user;

import valueobject.User;

/**
 * Created by Den on 11.03.2015.
 */
public interface IUserDAO {

    void addUser(User user);
    boolean updateUser(User user);
}
