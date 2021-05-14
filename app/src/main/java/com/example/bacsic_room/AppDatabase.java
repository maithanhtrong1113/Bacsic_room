package com.example.bacsic_room;



import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "Room-database";



    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }

    public abstract PersonDao personDao();
}

