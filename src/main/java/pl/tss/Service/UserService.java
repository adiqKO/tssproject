package pl.tss.Service;

import pl.tss.DAO.MysqlDAO;
import pl.tss.DAO.UserDAO;
import pl.tss.Model.User;

public class UserService {

    public User getUserByUsername(String username){
        MysqlDAO mysql = new MysqlDAO();
        UserDAO userDao = mysql.getUserDAO();
        User user = userDao.getUserByUsername(username);
        return user;
    }
}
