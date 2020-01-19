/*
* هنا انا مزود حجات مختلفة عن التاسك بتعانا علشان نحسن الكود بتعنا و المنطق بتاعنتا
* مزدود شغل حركة علشان نتعلم ازاي نعمل حركة في الابلكيشن بتعنا

* خليت الويب فيو في نفس الصفحة علشان نتعلم حاجة اسما Visibility

 * * دي وظيفتها التحكم في ظهور اي حاجة في الاكتيفتي  Visibility

 * خليت الليست كلها تتعرض في صفحة وحدا ويتغير ما بينهم حسب intent اللي مبعوت

 * بنتعلم ازاي نكون مينو ودي كانت مطلوبة مننا في التاسك
 *  */

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
    // عرفت views بتاعتي
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

//   الميسود دي وظيفتاهتا انها تظرهر textView
//    وتنادي علي starAnimation اللي بتحرك النص من الشمال لليمين
    public void onClickImageIcon() {
        objective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // السطر ده وظيفته يخلي التكست فيو يظهر
                //في الميسود بتاعت setVisbility هتلاقي 3 حجات
                //1- visible ودي وظيفتها تظهر الفيو
                // 2- gone ودي وظيفتها تخفي الفيو
                //3- ivvisible تبقي مخفيا بس حجزنا مكنها علي layout
                objectiveTv.setVisibility(View.VISIBLE);
                // الميسود اللي بتعمل حركة من الشامال لليمن لل textView
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
//  الميسوج دي وظيفتها تنتقل لل صفحتين التنين اللي هما objective , share list
//   وبتبعت اسم الزار اللي انت بتتك عليه
    public void onClickTextView() {
        objectiveTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
     // السطر ده معنها روح لصفحة objective و ابعت كلمة objective لل صفحة التنية
                startActivity(new Intent(Cv.this, Objective.class).
                        putExtra("objective", "objective"));
            }
        });
        /////////////////////////////////////////
        educationTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        // السطر ده معنا روح لصفحة shareList وابعت معها اسم الزرار اللي انت اتكيت عليه اللي هو education وابعت بقيت الزراير (((فضيااااا)))
                startActivity(new Intent(Cv.this, ShareList.class).putExtra("education", "education").
                        putExtra("skills", "").putExtra("courses", ""));

            }
        });
        /////////////////////////////////////////
        skillsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            // السطر ده معنا روح لصفحة shareList وابعت معها اسم الزرار اللي انت اتكيت عليه اللي هو skills وابعت بقيت الزراير (((فضيااااا)))
            public void onClick(View v) {
                startActivity(new Intent(Cv.this, ShareList.class).putExtra("education", "").
                        putExtra("skills", "skills").putExtra("courses", ""));
            }
        });
        /////////////////////////////////////////
        coursesTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // السطر ده معنا روح لصفحة shareList وابعت معها اسم الزرار اللي انت اتكيت عليه اللي هو courses وابعت بقيت الزراير (((فضيااااا)))
                startActivity(new Intent(Cv.this, ShareList.class).putExtra("education", "").
                        putExtra("skills", "").putExtra("courses", "courses"));
            }
        });
    }
// الميسود دي وظيفتها تعمل الحركة بس خلي بالك وانت بتعمل الحركة لازم تكون مجهزها ؟؟؟؟
// ازاي تجهز الحركة هتروح علي ملف res وتتك كليك يمين وتختار new  وتختار  android resource directory وبعدين هيطلع مربع هتخار من تاني مسطيل اللي مكتوب في values تختار anim
// وبعدين من anim هتتك كليك يمين عليها وتختار new وبعدين animation resource file
//    وبعدين هتاخد الكوده كوبي وتحطه فيه
//   <?xml version="1.0" encoding="utf-8"?>
//<set xmlns:android="http://schemas.android.com/apk/res/android"
//    android:fillAfter="true"
//    android:interpolator="@android:anim/linear_interpolator"
//            >
//    <translate
//    android:fromXDelta="-7%p"
//    android:toXDelta="4%p"
//    android:duration="250"
//            />
//</set>
//  وانت لوعايز تغير الحركة هتخش علي جوجل وتكتب how can i make animation in android وعيش حياتك
    public void starAnimation(TextView text) {
//   السطر ده وظيفته يعرف اوبجيكت وينادي علي الانيمشن اللي لسا عملنها فوق
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_to_right);
//     السطر ده وظيفته يخلي الانيميش اللي عملته يشتغل علي textView بتاعتك
        text.startAnimation(animation);
    }
// دي الميسود اللي بتكريت المينو اللي هما بيبقو تلات نقط فوق بعض وبيطلع منهم ليستا
//بس لازم نجهزها الاول ؟؟
//  نفس خطوات animation
//    بس بدل ما هختار anim هختار menu
//  menu resource file هختار   animation resource file  وبدل ما هختار
//    وبعدبن هعمل السطرين دو
//    <item
//        android:id="@+id/memories"
//        android:title="@string/memories" />
//    الitem الواحد عبارة عن الخانة اللي جو اليستا
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//      السطر ده وظيفته يحط القائمة اللي عملتها علي activity
        getMenuInflater().inflate(R.menu.menu_cv, menu);
        return true;
    }

// الميسود دي وظيفتها تعمل كل زار في القائمة مطلوب منه ايه
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
//    زرار  memories ينقلك علي صفحة memories الي كان مطلوب نعمل فيها gridView
            case R.id.memories:
                startActivity(new Intent(Cv.this, Memories.class));
                break;
//                بفتح صفحة الفيس بوك
            case R.id.fb:
                linearLayoutTypeCv.setVisibility(View.GONE); // هنا انا بخلي الظهور بتاع القائمة بتاعت اليست مخفي
                frameLayoutLine.setVisibility(View.GONE); // بخلي الخط اللي موجود مخفي
                webViewFb.setVisibility(View.VISIBLE); // بظهر الويب قيو
                webViewFb.getSettings().setJavaScriptEnabled(true);
                webViewFb.setWebViewClient(new WebViewClient());
                webViewFb.loadUrl("https://www.facebook.com");
                break;
//                بتبعت ايميل
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
//                بتبعت sms
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
//                بتكلم حد
            case R.id.callMe:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "01554046584"));
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
// الميسود دي بتخلي الظهور الافتراضي لل  activity بتاعتي
    public void defaultVisibility() {
        linearLayoutTypeCv.setVisibility(View.VISIBLE);// ظاهر
        frameLayoutLine.setVisibility(View.VISIBLE);// ظاهر
        webViewFb.setVisibility(View.GONE);// مخفي
    }
}
