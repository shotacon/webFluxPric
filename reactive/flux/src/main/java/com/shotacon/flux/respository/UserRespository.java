package com.shotacon.flux.respository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.shotacon.flux.entity.User;

@Repository
public interface UserRespository {

    @Select("select * from user")
    List<User> findAllUser();

    @Select("select * from user where id = #{id}")
    User findUserById(String id);

    @Insert("insert into user(id,name) values(#{id}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void saveUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUserById(String id);
}
