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
        calling(); // عرفت views بتاعتي
        handling();// نديت علي hadling علشان انفذ البرنامج وانتقل للصفحة التانية اللي هيا welcome
    }

    public void calling() {
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        emailAddress = findViewById(R.id.emailAddress);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

    }
// goToWelcomeActivityوفي الاخر نديت علي
    public void handling() {
        goToWelcomeActivity();
    }
// الميسود دي وظيفتها تجيب التكست من التكست فيو وترميهم في الميسود التانية اللي هي checkData
    public void getTextFromEditText() {
        firstNameS = firstName.getText().toString();
        lastNameS = lastName.getText().toString();
        emailAddressS = emailAddress.getText().toString();
        passwordS = password.getText().toString();
        checkData(firstNameS, lastNameS, emailAddressS, passwordS);
    }
// الميسود دي بتاخد الاسترنجات وبتتاكد انا سليمة ولو مش سليمة مش هينقل للصفحة التانية و لو سليمة هيبعتعتهم للصفحة التانية عن طريق sendStringVarToWelcomeActivity

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
// الميسود اللي بتبعت للصفحة التانية
    public void sendStringVarToWelcomeActivity(String fn, String ln, String e) {
        Intent intent = new Intent(LogIn.this,Welcome.class);
        intent.putExtra("firstName", fn);
        intent.putExtra("lastName", ln);
        intent.putExtra("email", e);
        startActivity(intent);
    }
// الميسود دي onClick بتاعت button حاطط جوها الاتنين ميسود بتوع text اللي هيتجاب و اليسود بتاعت البعت
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
