package pl.tss.DAO;

public class MysqlDAO {

    public UserDAO getUserDAO(){
        return new UserDAOImpl();
    }
    public PostDAO getPostDAO(){
        return new PostDAOImpl();
    }
}
