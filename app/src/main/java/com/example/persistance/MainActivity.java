package com.example.persistance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final static String name = "Name";
    private final static String surname = "Surname";
    private final static String age = "Age";
    private final static String phone = "Phone number";
    private final static String id = "Id";

    private static String id_text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            if(savedInstanceState.containsKey(name)){
                String bName = savedInstanceState.getString(name);
                EditText eName = (EditText) findViewById(R.id.editName);
                eName.setText(bName);
            }

            if(savedInstanceState.containsKey(surname)){
                String bSurname = savedInstanceState.getString(surname);
                EditText eSurname = (EditText) findViewById(R.id.editSurname);
                eSurname.setText(bSurname);
            }

            if(savedInstanceState.containsKey(age)){
                String bAge = savedInstanceState.getString(age);
                EditText eAge = (EditText) findViewById(R.id.editAge);
                eAge.setText(bAge);
            }

            if(savedInstanceState.containsKey(phone)){
                String bPhone = savedInstanceState.getString(phone);
                EditText ePhone = (EditText) findViewById(R.id.editPhone);
                ePhone.setText(bPhone);
            }

            if (savedInstanceState.containsKey(id)){
                id_text = savedInstanceState.getString(id);
                TextView tId = (TextView) findViewById(R.id.Id);
                tId.setText(id_text);
            }
        }

        if(id_text == ""){
            id_text = idGen();
            TextView tId = (TextView) findViewById(R.id.Id);
            tId.setText(id_text);
        }

        EditText ePassword = (EditText) findViewById(R.id.editPassword);
        ePassword.setText("");

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        EditText eName = (EditText) findViewById(R.id.editName);
        EditText eSurname = (EditText) findViewById(R.id.editSurname);
        EditText eAge = (EditText) findViewById(R.id.editAge);
        EditText ePhone = (EditText) findViewById(R.id.editPhone);

        String bName = eName.getText().toString();
        String bSurname = eSurname.getText().toString();
        String bAge = eAge.getText().toString();
        String bPhone = ePhone.getText().toString();

        savedInstanceState.putString(name, bName);
        savedInstanceState.putString(surname, bSurname);
        savedInstanceState.putString(age, bAge);
        savedInstanceState.putString(phone, bPhone);
        savedInstanceState.putString(id, id_text);

        Toast.makeText(this, "Etat de l'activité sauvegardé", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState.containsKey(name)){
            String bName = savedInstanceState.getString(name);
            EditText eName = (EditText) findViewById(R.id.editName);
            eName.setText(bName);
        }

        if(savedInstanceState.containsKey(surname)){
            String bSurname = savedInstanceState.getString(surname);
            EditText eSurname = (EditText) findViewById(R.id.editSurname);
            eSurname.setText(bSurname);
        }

        if(savedInstanceState.containsKey(age)){
            String bAge = savedInstanceState.getString(age);
            EditText eAge = (EditText) findViewById(R.id.editAge);
            eAge.setText(bAge);
        }

        if(savedInstanceState.containsKey(phone)){
            String bPhone = savedInstanceState.getString(phone);
            EditText ePhone = (EditText) findViewById(R.id.editPhone);
            ePhone.setText(bPhone);
        }

        if (savedInstanceState.containsKey(id)){
            id_text = savedInstanceState.getString(id);
            TextView tId = (TextView) findViewById(R.id.Id);
            tId.setText(id_text);
        }

        EditText ePassword = (EditText) findViewById(R.id.editPassword);
        ePassword.setText("");

        Toast.makeText(this, "Activite restauree", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "Activite detruite", Toast.LENGTH_SHORT).show();
    }

    protected String idGen(){

        Random rng = new Random();
        Integer id = rng.nextInt(1000);

        return id.toString();
    }
}