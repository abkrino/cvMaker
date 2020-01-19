package com.example.cvmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    EditText firstName, lastName, emailAddress, password;
    Button login;
    Person person;
    String firstNameS, lastNameS, emailAddressS, passwordS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calling();
        handling();
    }

    public void calling() {
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        emailAddress = findViewById(R.id.emailAddress);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

    }

    public void handling() {
        goToWelcomeActivity();
    }

    public void getTextFromEditText() {
        firstNameS = firstName.getText().toString();
        lastNameS = lastName.getText().toString();
        emailAddressS = emailAddress.getText().toString();
        passwordS = password.getText().toString();
        checkData(firstNameS, lastNameS, emailAddressS, passwordS);
    }

    public void checkData(String fn, String ln, String e, String p) {
        if (fn.isEmpty() ) {
            firstName.setError("من فضلك ادخل الاسم ");
//            firstName.requestFocus();
            return;
        }else if (ln.isEmpty()){
            lastName.setError("من فضلك ادخل الاسم ");
        }
        if (e.isEmpty() || !e.contains("@")) {
            emailAddress.setError("من فضلك ادخل البريد بالصيغة الصحيحة ");
//            firstName.requestFocus();
            return;
        }
        if (p.isEmpty() || p.length() < 7) {
            password.setError("ادخل كلمة مرور ");
            return;
        }
        person = new Person(fn, ln, e, p);
        sendStringVarToWelcomeActivity(firstNameS, lastNameS, emailAddressS);

    }

    public void sendStringVarToWelcomeActivity(String fn, String ln, String e) {
        Intent intent = new Intent(LogIn.this,Welcome.class);
        intent.putExtra("firstName", fn);
        intent.putExtra("lastName", ln);
        intent.putExtra("email", e);
        startActivity(intent);
    }

    public void goToWelcomeActivity() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTextFromEditText();
                goToWelcomeActivity();
                Toast.makeText(LogIn.this, "welcome " + firstNameS, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
