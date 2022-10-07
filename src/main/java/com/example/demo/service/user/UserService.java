package com.example.demo.service.user;

import com.example.demo.mapper.user.UserAccountMapper;
import com.example.demo.mapper.user.UserInfoMapper;
import com.example.demo.model.user.UserAccount;
import com.example.demo.model.user.UserInfo;
import com.example.demo.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserAccountMapper userAccountMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    /*
    * 列出所有有效用户
    */
    public List<UserAccount> listUsers(int status){
        return userAccountMapper.selectAll(status);
    }
    /*
     * 查找用户
     */
    public UserAccount findUser(String userid){
        return userAccountMapper.findByUserid(userid);
    }
    /*
     * 用户登录
     */
    public Map<String,Object> login(String userid, String password){
        Map<String,Object> result = new HashMap<>();

        if (userid.equals("") || password.equals("")){
            result.put("code",1003);
            result.put("message","请输入账号或者密码");
        } else {
            UserAccount userInfo = userAccountMapper.findByUserid(userid);
            if (userInfo != null){
                if (userInfo.getPassword().equals(password)){
                    String token = TokenUtil.generateToken(userInfo);
                    result.put("code",200);
                    result.put("message","登陆成功");
                    result.put("token",token);

                }else {
                    result.put("code",1001);
                    result.put("message","账号密码输入错误");
                }
            }else {
                result.put("code",1002);
                result.put("message","用户不存在");
            }
        }
        return result;
    }
    /*
     * 用户注册
     */
    public Map<String,Object> register(UserAccount userAccount, String pwAgain, String code, HttpSession session){
        Map<String,Object> result = new HashMap<>();

        if (userAccount.getPassword().equals("") || userAccount.getEmail().equals("") || userAccount.getUserid().equals("")){
            result.put("code",1003);
            result.put("message","请输入用户注册信息");
        } else if (code.equals("")) {
            result.put("code",1007);
            result.put("message","请输入邮箱验证码");
        } else {
            UserAccount userInfo = userAccountMapper.findByUserid(userAccount.getUserid());
            if (userInfo != null){
                result.put("code",1004);
                result.put("message","该用户已注册");
            }else {
                String isCode = (String) session.getAttribute("code");
                if (pwAgain.equals(userAccount.getPassword()) && code.equals(isCode)){
                    userAccountMapper.add(userAccount);
                    result.put("code",200);
                    result.put("message","注册成功");
                } else if (! code.equals(isCode)) {
                    result.put("code",1005);
                    result.put("message","邮箱验证码输入错误");
                } else if (! pwAgain.equals(userAccount.getPassword())) {
                    result.put("code",1001);
                    result.put("message","两次密码输入不一致");
                }else{
                    result.put("code",1006);
                    result.put("message","注册失败");
                }
            }
        }
        return result;
    }

    /*
     * 用户修改密码
     */
    public Map<String,Object> changePasswoed(UserAccount userAccount,String pwAgain, String code, HttpSession session){
        Map<String,Object> result = new HashMap<>();

        if (userAccount.getUserid().equals("") || userAccount.getPassword().equals("")){
            result.put("code",1003);
            result.put("message","请输入账号或密码");
        } else if (code.equals("")) {
            result.put("code",1007);
            result.put("message","请输入邮箱验证码");
        }else if (userAccount.getEmail().equals("")) {
            result.put("code",1008);
            result.put("message","请输入邮箱");
        }else {
            UserAccount userInfo = userAccountMapper.findByUserid(userAccount.getUserid());
            if (userInfo != null){
                String isCode = (String) session.getAttribute("code");
                if (userAccount.getPassword().equals(pwAgain) && code.equals(isCode)){
                    userAccountMapper.changePassword(userAccount);
                    result.put("code",200);
                    result.put("message","密码修改成功");
                } else if (!code.equals(isCode)) {
                    result.put("code",1005);
                    result.put("message","邮箱验证码输入错误");
                } else if (! pwAgain.equals(userAccount.getPassword())) {
                    result.put("code",1001);
                    result.put("message","两次密码输入不一致");
                }else{
                    result.put("code",1006);
                    result.put("message","注册失败");
                }
            }else {
                result.put("code",1002);
                result.put("message","用户不存在");
            }
        }
        return result;
    }

//    public List<UserAccount> unionSelect(){
//        return userAccountMapper.unionSelect();
//    }

    public List<UserInfo> selectUserInfoByUserid(String userid){
        return userInfoMapper.selectOneUserByUserid(userid);
    }
}
