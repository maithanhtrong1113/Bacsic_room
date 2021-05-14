package com.example.bacsic_room;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvResult;
    private Button btnAdd, btnRemove, btnCancel;
    private EditText etName;
    private List<Person> persons;
    private PersonAdapter personAdapter;
    private AppDatabase db;
    private  PersonDao personDao;

    private int deletedId  = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getInstance(getApplicationContext());
        personDao = db.personDao();

        lvResult = findViewById(R.id.lvResult);
        etName = findViewById(R.id.etName);
        btnAdd = findViewById(R.id.btnAdd);
        btnRemove = findViewById(R.id.btnRemove);
        btnCancel = findViewById(R.id.btnCancel);


        persons = personDao.getAll();

        personAdapter = new PersonAdapter(MainActivity.this, persons, R.layout.item_layout );


        lvResult.setAdapter(personAdapter);

        btnAdd.setOnClickListener(v -> {

            String name  = etName.getText().toString();

            Person person = new Person(name);
            personDao.addPerson(person);

            capNhatDuLieu();
            etName.setText("");

        });

        lvResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                deletedId = (int) id;
                etName.setText(personDao.getById((int)id).getName());


            }
        });

        btnRemove.setOnClickListener(v -> {

            if(deletedId != -1){
                personDao.deletePerson(personDao.getById(deletedId));

                capNhatDuLieu();
                etName.setText("");
                deletedId = -1;
            }

        });

        btnCancel.setOnClickListener(v -> {
            deletedId = -1;
            etName.setText("");
        });
    }

    private  void capNhatDuLieu(){

        lvResult.setAdapter(new PersonAdapter(MainActivity.this, personDao.getAll(), R.layout.item_layout ));
    }

}