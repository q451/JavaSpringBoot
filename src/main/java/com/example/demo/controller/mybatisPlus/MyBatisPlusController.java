package com.example.demo.controller.mybatisPlus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.mybatisPlus.UserAccountTestMapper;
import com.example.demo.model.mybatisPlus.UserAccountTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;

public class MyBatisPlusController {
    @Autowired
    private UserAccountTestMapper userAccountTestMapper;

    public void selectById(){
        //只能根据id查询查询一条，没有返回一条null
        userAccountTestMapper.selectById(44);
        System.out.println(userAccountTestMapper.selectById(44));
    }

    public void selectAlls(){
        //查询所有的用户
        List<UserAccountTest> users = userAccountTestMapper.selectList(null);
        Iterator<UserAccountTest> it = users.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public void selectConditions(){
        //条件查询
        QueryWrapper<UserAccountTest> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);     //设置等值查询
//        queryWrapper.lt("age", 29); //设置小于查询
//        queryWrapper.le("age", 29); //设置小于等于查询
//        queryWrapper.gt("age", 22); //设置大于查询
//		  queryWrapper.ge("status", 1); //设置大于等于查询
        List<UserAccountTest> conditionSelect = userAccountTestMapper.selectList(queryWrapper);
        Iterator<UserAccountTest> it = conditionSelect.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public void likeSelect(){
        QueryWrapper<UserAccountTest> queryWrapper = new QueryWrapper<>();
        //like：只要包含val中的值即可
        //queryWrapperLike.like("username","三");
        //likeLeft:查询尾部包含val值的数据
        //queryWrapperLike.likeLeft("username","三");
        //likeRight: 查询开头包含val值的数据
        queryWrapper.likeRight("userid","1930");
        List<UserAccountTest> likeSelect = userAccountTestMapper.selectList(queryWrapper);
        likeSelect.forEach(user -> System.out.println("user=" + user));
    }

    public void pageSelect(){
        IPage<UserAccountTest> page = new Page(1,2);
        QueryWrapper<UserAccountTest> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);
        IPage<UserAccountTest> userIPage = userAccountTestMapper.selectPage(page, queryWrapper);
        long total = userIPage.getSize();
        System.out.println("记录数：" + total);
        userIPage.getRecords().forEach(user -> System.out.println(user));
    }

    public void testSave(){
        UserAccountTest userAccountTest = new UserAccountTest();
        userAccountTest.setUserid("王五");
        userAccountTest.setPassword("885ffssdda");
        userAccountTest.setEmail("7952@qq.com");
        userAccountTestMapper.insert(userAccountTest);
    }

    public void testUpdateById(){
        UserAccountTest user = userAccountTestMapper.selectById("1");
        user.setStatus(1);
        userAccountTestMapper.updateById(user);
    }
    //批量修改
    public void testUpdate(){
        UserAccountTest user = new UserAccountTest();
        user.setStatus(1);
        QueryWrapper<UserAccountTest> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age", 22);
        userAccountTestMapper.update(user, queryWrapper);
    }
    //删除一个
    public void testDeleteById(){
        userAccountTestMapper.deleteById(1);
    }

    //批量删除
    public void testDelete(){
        QueryWrapper<UserAccountTest> wrapper = new QueryWrapper<>();
        wrapper.ge("id", 44);
        userAccountTestMapper.delete(wrapper);
    }
}
