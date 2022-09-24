package service;

import dao.UserAccountDao;
import model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserAccountService implements UserAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addUserAccount(UserAccount account) {
        //1.创建sql语句
        String sql="insert into user_account values(?,?,?)";
        //2.调用方法实现
        //3.参数是可变参数，是一个数组形式，因此存在一种变式
        //        int update = jdbcTemplate.update(sql, book.getUserId(), book.getUsername());
        //变式为
        Object[] args= {account.getUserid(), account.getPassword(), account.getStatus()};
        int update = jdbcTemplate.update(sql, args);

        //输出影响的值
        System.out.println(update);
    }

    @Override
    public int selectCount() {
        String sql = "select count(*) from user_account";
        /*
            第一个参数：sql
            第二个参数：返回类型的class
         */
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);

        return integer;
    }

}
