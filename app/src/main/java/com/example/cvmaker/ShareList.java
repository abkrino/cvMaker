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
// بنادي علي الدتا اللي بتاها من calss ShareList
// وبعرف الفيو
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
//الميسود دي وظيفتها انها تشوف مين الزرار اللي انت اتكيت عليه عن طريق الدتا اللي اتبعت
//  فالو اتبعت كلمة education والباقي فاضي يساوي الكلمة ب check
    public String checkIntent() {
//        فالو اتبعت كلمة education والباقي فاضي يساوي الكلمة ب check
        if (education.equals("education") && skills.isEmpty() && courses.isEmpty()) {
            check = education;
//            فالو اتبعت كلمة skills والباقي فاضي يساوي الكلمة ب check
        } else if (education.isEmpty() && skills.equals("skills") && courses.isEmpty()) {
            check = skills;
            //            فالو اتبعت كلمة courses والباقي فاضي يساوي الكلمة ب check

        } else if (education.isEmpty() && skills.isEmpty() && courses.equals("courses")) {
            check = courses;
        }
// وفي الاخر بترجع قيمة check
        return check;
    }
// بتحط اليستة حسب الكلمة اللي بتديهلها
    public void setTypeList(String type) {
//        عملت switch علشان اقارن الكلمة اللي جيا اللي هيا type
        switch (type) {
//           لو education حط اليسته بتاعت education
//      وخلي بالك انا عملت adapter في كلاس لوحد
            case "education":
                list_item.setAdapter(new ListAdapter(ShareList.this, educationL, imageE, "education"));
                break;
            //           لو skills حط اليسته بتاعت skills
            case "skills":
                list_item.setAdapter(new ListAdapter(ShareList.this, skillsL, imageS, "skills"));
                break;
            //           لو courses حط اليسته بتاعت courses

            case "courses":
                list_item.setAdapter(new ListAdapter(ShareList.this, coursesL, imageC, "courses"));
                break;
        }
    }
}
