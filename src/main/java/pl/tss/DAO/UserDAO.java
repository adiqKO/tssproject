package pl.tss.DAO;

import pl.tss.Model.User;

public interface UserDAO extends GenericDAO<User,Long> {

    User getUserByUsername(String username);
}
