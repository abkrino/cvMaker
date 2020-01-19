package com.example.cvmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    String firstNameS, lastNameS, emailAddressS;
    Bundle rx;
    TextView firstNameTV, lastNameTV,emailAddressTv;
    Button btCheckCv;
    ImageView imageUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        calling();
        handling();
    }

    private void calling() {
        firstNameTV = findViewById(R.id.firstNameTV);
        lastNameTV = findViewById(R.id.lastNameTV);
        btCheckCv = findViewById(R.id.btCheckCv);
       imageUser = findViewById(R.id.imageUser);
        emailAddressTv =findViewById(R.id.emailAddressTv);
        getDataFromLoginActivity();
    }

    private void handling() {
        calling();
        setDataToActivity();
        goToCvActivity();
    }

    public void getDataFromLoginActivity() {
        rx = getIntent().getExtras();
        firstNameS = rx.getString("firstName");
        lastNameS = rx.getString("lastName");
        emailAddressS = rx.getString("email");
    }
    public void setDataToActivity() {
        firstNameTV.setText(firstNameS);
        lastNameTV.setText(lastNameS);
        emailAddressTv.setText(emailAddressS);
        checkUserImage();
    }
    public void checkUserImage(){
        switch(firstNameS){
            case "mahmoud":
                imageUser.setImageResource(R.color.Blue);
                break;
            case "hassan":
                imageUser.setImageResource(R.color.Blue_AliceBlue);
                break;
            case "mostafa":
                imageUser.setImageResource(R.color.Blue_Aqua);
                break;
            case "may":
                imageUser.setImageResource(R.color.Blue_DeepSkyBlue);
                break;
            case "aya":
                imageUser.setImageResource(R.color.Blue_BlueViolet);
                break;
            default:
                imageUser.setImageResource(R.color.Black);
        }
    }
    public void goToCvActivity(){
        btCheckCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this,Cv.class));
            }
        });

    }

}
