package com.example.parkapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {


    EditText name, surname, email, username, password, age;
    RadioGroup gender;
    Button register;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        register = findViewById(R.id.registerbutton);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameVal = name.getText().toString();
                String surnameVal = surname.getText().toString();
                String emailVal = email.getText().toString();
                String usernameVal = username.getText().toString();
                String passVal = password.getText().toString();
                String ageVal = age.getText().toString();
                RadioButton checked = findViewById(gender.getCheckedRadioButtonId());
                String genderVal = checked.getText().toString();

                com.example.parkapplication.CustomerModel customerModel;
                try {
                    customerModel = new com.example.parkapplication.CustomerModel(nameVal, surnameVal, emailVal, usernameVal, passVal, Integer.parseInt(ageVal), genderVal);
                    Toast.makeText(com.example.parkapplication.RegisterActivity.this, "Successful Registration", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(com.example.parkapplication.RegisterActivity.this, "Try again", Toast.LENGTH_SHORT).show();
                    customerModel = new com.example.parkapplication.CustomerModel("Name", "Surname", "Email", "Username", "Password", 0, "Gender");
                }

                Database database = new Database(com.example.parkapplication.RegisterActivity.this, null, null, 2);

                database.addNewUser(customerModel);

                //Toast.makeText(RegisterActivity.this, "Success = " + success, Toast.LENGTH_SHORT).show();


            }
        });




    }

}