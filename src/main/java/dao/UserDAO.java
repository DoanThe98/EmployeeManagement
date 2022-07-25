package dao;

import model.User;

public interface UserDAO {
    public User getUserByEmailAndPassword(String user, String pass);
}
