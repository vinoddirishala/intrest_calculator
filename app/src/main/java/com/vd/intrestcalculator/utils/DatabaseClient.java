package com.vd.intrestcalculator.utils;

import android.content.Context;

import androidx.room.Room;

/**
 * Created by Vinod Dirishala on 06-11-2021 21:37
 **/
public class DatabaseClient {

    private Context mContext;
    ICDBSingleton icdbSingleton;
    private static DatabaseClient databaseClient;

    public DatabaseClient(Context mContext) {
        this.mContext = mContext;
        icdbSingleton = Room.databaseBuilder(mContext,ICDBSingleton.class,"ic")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    public static synchronized DatabaseClient getInstance(Context mContext){
        if (databaseClient == null){
            databaseClient = new DatabaseClient(mContext);
        }
        return databaseClient;
    }

    public ICDBSingleton getDatabase(){
        return icdbSingleton;
    }



}

