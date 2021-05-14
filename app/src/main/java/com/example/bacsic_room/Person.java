package com.example.bacsic_room;



import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person {

    @PrimaryKey(autoGenerate = true)
    private  int id;
    private  String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

