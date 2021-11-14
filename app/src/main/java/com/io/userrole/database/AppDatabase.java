package com.io.userrole.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.io.userrole.dao.UserDao;
import com.io.userrole.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
