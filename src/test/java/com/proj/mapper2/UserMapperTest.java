//package com.proj.mapper2;
//
//
//import com.proj.entity.User;
//import com.proj.mapper.UserMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@SpringBootTest
//class UserMapperTest {
//
//    @Autowired
//    private UserMapper userMapper;
//
////    @Test
////    void testInsert(){
////        User user = new User();
////        String str = new String("fw");
//////        Long id = new Long(10);
//////        user.setId(id);
////        user.setName(str);
////        user.setAge(20);
////        user.setEmail("email@email.com");
////
////        userMapper.insert(user);
////
////    }
//
////    @Test
////    void testSelectById(){
////        User user = userMapper.selectById(1L);
////        System.out.println("user = " + user);
////    }
//
////    @Test
////    void testDeleteById(){
////        userMapper.deleteById(11L);
////    }
//
//    @Test
//    void queryByIds(){
//        List<Long> ids = new ArrayList<Long>();
//        ids.add(1L);
//        ids.add(2L);
//        ids.add(3L);
//        List<User> userList = userMapper.selectByIds(ids);
//        System.out.println("userList = " + userList);
//    }
//
////    @Test
////    void deleteById(){
////        userMapper.deleteById(10L);
////    }
//}
