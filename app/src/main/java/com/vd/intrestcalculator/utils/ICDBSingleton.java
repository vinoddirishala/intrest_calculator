package com.vd.intrestcalculator.utils;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by Vinod Dirishala on 06-11-2021 21:34
 **/
@Database(entities = ICEntity.class,version = 1)
public abstract class ICDBSingleton extends RoomDatabase {
    public abstract ICDAO icdao();
}
