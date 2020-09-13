package com.fankf.jdbc.dao.impl;

import com.fankf.jdbc.bean.User1;
import com.fankf.jdbc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * fankunfeng
 * 2020-09-12 13:37
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addUser(User1 user) {
        String sql = "insert into user1 values (?,?,?)";
        Object[] args = {user.getId(),user.getUsername(),user.getAge()};
        int update = jdbcTemplate.update(sql, args);
        return update;
    }

    @Override
    public int updateUserById(User1 user) {
        String sql = "update user1 set username = ? , age = ? where id = ?";
        Object[] args = {user.getUsername(),user.getAge(),user.getId()};
        int update = jdbcTemplate.update(sql, args);
        return update;
    }

    @Override
    public int deleteUserById(int id) {
        String sql = "delete from user1 where id = ?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }

    @Override
    public int countUser() {
        String sql = "select count(1) from user1";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public User1 selectUserById(int id) {
        String sql = "select * from user1 where id = ?";
        User1 user1 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User1.class), id);
        return user1;
    }

    @Override
    public List<User1> selectUsers() {
        String sql = "select * from user1";
        List<User1> user1List = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User1.class));
        return user1List;
    }

    @Override
    public int[] insertUser1s(List<Object[]> args) {
        String sql = "insert into user1 values (?,?,?)";
        int[] user1List = jdbcTemplate.batchUpdate(sql, args);
        return user1List;
    }

    @Override
    public int[] updateUser1s(List<Object[]> args) {
        String sql = "update user1 set username = ? , age = ? where id = ?";
        int[] user1List = jdbcTemplate.batchUpdate(sql, args);
        return user1List;
    }

    @Override
    public int[] deleteUser1s(List<Object[]> args) {
        String sql = "delete from user1 where id = ?";
        int[] user1List = jdbcTemplate.batchUpdate(sql, args);
        return user1List;
    }
}
