package com.ease.architecture.dao.mapper;

import com.ease.architecture.entity.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cache.decorators.FifoCache;


@CacheNamespace(blocking = true, eviction = FifoCache.class)
public interface UserMapper {

    @Select({"SELECT * FROM t_user_1 WHERE name=#{name,jdbcType=VARCHAR}"})
    public User findByName(@Param("name") String name);

    @Select("SELECT * FROM t_user_1 WHERE name=#{name,jdbcType=VARCHAR} AND password=#{password,jdbcType=VARCHAR}")
    public User findByNameAndPassword(@Param("name") String name, @Param("password") String password);

    @Insert("INSERT INTO t_user_1 (id,name,password) VALUES (#{id},#{name},#{password})")
    public int insertUser(User user);
}
