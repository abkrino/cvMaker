package com.example.cvmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ShareList extends AppCompatActivity {
    ListView list_item;
    Bundle rs;
    String education, skills, courses, check;
    String[] educationL = {"a", "b", "c", "d", "f", "g"};
    String[] skillsL = {"as", "bs", "cs", "ds", "fs", "gs"};
    String[] coursesL = {"ac", "bc", "cc", "dc", "fc", "gc"};
    int[] imageE = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_background
            , R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};

    int[] imageS = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground
            , R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground};

    int[] imageC = {R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round
            , R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_list);
        calling();
        handling();
    }

    private void calling() {
        list_item = findViewById(R.id.listShare);
        rs = getIntent().getExtras();
        education = rs.getString("education");
        skills = rs.getString("skills");
        courses = rs.getString("courses");
    }

    private void handling() {
        String ts = checkIntent();
        setTypeList(ts);
    }

    public String checkIntent() {
        if (education.equals("education") && skills.isEmpty() && courses.isEmpty()) {
            check = education;
        } else if (education.isEmpty() && skills.equals("skills") && courses.isEmpty()) {
            check = skills;
        } else if (education.isEmpty() && skills.isEmpty() && courses.equals("courses")) {
            check = courses;
        }
        return check;
    }

    public void setTypeList(String type) {
        //todo فاضل اعدل في الادبتر
        switch (type) {
            case "education":
                list_item.setAdapter(new ListAdapter(ShareList.this, educationL, imageE, "education"));
                break;
            case "skills":
                list_item.setAdapter(new ListAdapter(ShareList.this, skillsL, imageS, "skills"));
                break;
            case "courses":
                list_item.setAdapter(new ListAdapter(ShareList.this, coursesL, imageC, "courses"));
                break;
        }
    }
}
