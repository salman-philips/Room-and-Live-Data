package com.roomandlivedataroom1.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {NoteEntity.class},version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {

    public static final String DATABASE_NAME="NoteDatabase";
    public static volatile ApplicationDatabase applicationDatabaseInstance;
    //volatile allows only one memory storage of the variable and will not be stored locally in thread cache/memories but in the shared cache or main memory
    //any new update will update the main memory or shared cache and read will be done on the variable instance on the main memory or shared cache not locally

    private static final Object LOCK=new Object();

    public abstract NoteDao noteDao();

    public static ApplicationDatabase getInstance(Context context){
        if(applicationDatabaseInstance==null){
            //this particular peace of code allows only one thread to perform the code block operation and rest has to wait
            synchronized (LOCK){
                if(applicationDatabaseInstance==null){
                    applicationDatabaseInstance= Room.databaseBuilder(context.getApplicationContext(),ApplicationDatabase.class,DATABASE_NAME).build();
                }
            }


        }
        return applicationDatabaseInstance;
    }


    }





