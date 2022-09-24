package dao;
import model.UserAccount;

public interface UserAccountDao {

    //添加
    public void addUserAccount(UserAccount account);

    //查询记录数量
    int selectCount();

}
