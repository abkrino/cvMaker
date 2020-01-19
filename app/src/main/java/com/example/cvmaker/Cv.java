package com.example.cvmaker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Cv extends AppCompatActivity {
    ImageView objective, education, skills, courses;
    TextView objectiveTv, educationTv, skillsTv, coursesTv;
    LinearLayout linearLayoutTypeCv;
    FrameLayout frameLayoutLine;
    WebView webViewFb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv);
        calling();
        handling();
    }

    private void calling() {
        objective = findViewById(R.id.objective);
        education = findViewById(R.id.education);
        skills = findViewById(R.id.skills);
        courses = findViewById(R.id.courses);
        ////////////////////////////////////////
        objectiveTv = findViewById(R.id.objectiveTv);
        educationTv = findViewById(R.id.educationTv);
        skillsTv = findViewById(R.id.skillsTv);
        coursesTv = findViewById(R.id.coursesTv);
        ///////////////////////////////////////
        linearLayoutTypeCv = findViewById(R.id.linearLayoutTypeCv);
        frameLayoutLine = findViewById(R.id.frameLayoutLine);
        webViewFb = findViewById(R.id.webViewFb);
    }

    private void handling() {

        defaultVisibility();
        onClickImageIcon();
        onClickTextView();
    }

    public void onClickImageIcon() {
        objective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objectiveTv.setVisibility(View.VISIBLE);
                starAnimation(objectiveTv);
            }
        });
        //////////////////////////////////////////////
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                educationTv.setVisibility(View.VISIBLE);
                starAnimation(educationTv);
            }
        });
        //////////////////////////////////////////////
        skills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skillsTv.setVisibility(View.VISIBLE);
                starAnimation(skillsTv);
            }
        });
        ////////////////////////////////////////
        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coursesTv.setVisibility(View.VISIBLE);
                starAnimation(coursesTv);
            }
        });
    }

    public void onClickTextView() {
        objectiveTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cv.this, Objective.class).
                        putExtra("objective", "objective"));
            }
        });
        /////////////////////////////////////////
        educationTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cv.this, ShareList.class).putExtra("education", "education").
                        putExtra("skills", "").putExtra("courses", ""));

            }
        });
        /////////////////////////////////////////
        skillsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cv.this, ShareList.class).putExtra("education", "").
                        putExtra("skills", "skills").putExtra("courses", ""));
            }
        });
        /////////////////////////////////////////
        coursesTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cv.this, ShareList.class).putExtra("education", "").
                        putExtra("skills", "").putExtra("courses", "courses"));
            }
        });
    }

    public void starAnimation(TextView text) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_to_right);
        text.startAnimation(animation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cv, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.memories:
                startActivity(new Intent(Cv.this, Memories.class));
                break;
            case R.id.fb:
                linearLayoutTypeCv.setVisibility(View.GONE);
                frameLayoutLine.setVisibility(View.GONE);
                webViewFb.setVisibility(View.VISIBLE);
                webViewFb.getSettings().setJavaScriptEnabled(true);
                webViewFb.setWebViewClient(new WebViewClient());
                webViewFb.loadUrl("https://www.facebook.com");
                break;
            case R.id.sendEmail:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("email"));
                String[] s = {"best_team@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, s);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Enter subject");
                intent.putExtra(Intent.EXTRA_TEXT, "Enter your email body");
                intent.setType("massage/rfc822");
                Intent choser = Intent.createChooser(intent, "launch Email");
                startActivity(choser);
                break;
            case R.id.sendMassage:
                String number = "01554046584";  // The number on which you want to send SMS
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
//                or
//                public void sendSMS(View v) {
//                    Uri uri = Uri.parse("smsto:12346556");
//                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
//               it.putExtra("sms_body", "Here you can set the SMS text to be sent");
//                startActivity(it);
//                }
                break;
            case R.id.callMe:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "01554046584"));
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void defaultVisibility() {
        linearLayoutTypeCv.setVisibility(View.VISIBLE);
        frameLayoutLine.setVisibility(View.VISIBLE);
        webViewFb.setVisibility(View.GONE);
    }
}
