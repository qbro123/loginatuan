package com.io.userrole.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.io.userrole.model.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user WHERE username LIKE :username LIMIT 1")
    User findByName(String username); //find User in Database

    @Query("SELECT * FROM user WHERE username LIKE :username AND password LIKE :password LIMIT 1")
    User login(String username, String password); //find User in Database

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

    @Update
    void update(User user);

}
