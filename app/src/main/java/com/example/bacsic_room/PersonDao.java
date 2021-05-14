package com.example.bacsic_room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM person")
    List<Person> getAll();

    @Query("SELECT * FROM person WHERE id = :personId ")
    Person getById(Integer personId);

    @Insert
    void addPerson(Person person);

    @Delete
    void deletePerson(Person person);


}