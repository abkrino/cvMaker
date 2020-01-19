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
        calling();// عرفت views بتاعتي
        handling();// نديت علي hadling علشان انفذ البرنامج وانتقل للصفحة التانية اللي هيا Cv

    }
// عرفت الفيو ونديت علي الميسود اللي بتجيب الدتا من الاكتيفتي التانية
    private void calling() {
        firstNameTV = findViewById(R.id.firstNameTV);
        lastNameTV = findViewById(R.id.lastNameTV);
        btCheckCv = findViewById(R.id.btCheckCv);
       imageUser = findViewById(R.id.imageUser);
        emailAddressTv =findViewById(R.id.emailAddressTv);
        getDataFromLoginActivity();
    }

    private void handling() {
        setDataToActivity();
        goToCvActivity();
    }
//الميسود اللي بتجيب الدتا من الاكتيفتي التانية
    public void getDataFromLoginActivity() {
        rx = getIntent().getExtras();
        firstNameS = rx.getString("firstName");
        lastNameS = rx.getString("lastName");
        emailAddressS = rx.getString("email");
    }
   //الميسود دي وظيفتها تحط الدتا علي welcome activity
    public void setDataToActivity() {
        firstNameTV.setText(firstNameS);
        lastNameTV.setText(lastNameS);
        emailAddressTv.setText(emailAddressS);
        checkUserImage();
    }
//    الميسود دي وظيفتاها تغير الصورة حسب اسم الشخص
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
// الميسود دي وظيفتها تروح لل cv activity
    public void goToCvActivity(){
        btCheckCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this,Cv.class));
            }
        });

    }

}
