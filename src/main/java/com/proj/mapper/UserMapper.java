package com.proj.mapper;


import com.proj.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectByIds(List<Long> ids);

    // 查询所有用户
    List<User> selectAll();

    // 根据 ID 查询用户
    User selectById(@Param("id") int id);

    // 插入用户
    int insert(User user);

    // 更新用户
    int updateById(User user);

    // 删除用户
    int deleteById(@Param("id") Long id);
}
