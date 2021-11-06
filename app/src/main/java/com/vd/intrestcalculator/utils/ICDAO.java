package com.vd.intrestcalculator.utils;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinod Dirishala on 06-11-2021 21:32
 **/
@Dao
public interface ICDAO {

    @Query("select * from icentity")
    List<ICEntity> getAll();

    @Insert
    void insert(ICEntity task);

    @Delete
    void delete(ICEntity task);

    @Update
    void update(ICEntity task);


}
