package com.example.demo.mapper.user;
import com.example.demo.model.user.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserAccountMapper {
    //添加一个用户
    void add (UserAccount userAccount);
    //查找一个用户
    UserAccount findByUserid(String userid);
    //修改密码
    void changePassword (UserAccount userAccount);
    //所有有效用户
    List<UserAccount> selectAll(int status);

    List<UserAccount> unionSelect();

}
