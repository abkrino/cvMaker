package com.example.cvmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Objective extends AppCompatActivity {
    ImageView imageIcone;
    TextView textObjective;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objective);
        calling();
        handling();
    }

    private void calling() {
        imageIcone = findViewById(R.id.imageIcon);
        textObjective = findViewById(R.id.textObjective);
    }

    private void handling() {
    imageIcone.setImageResource(R.drawable.ic_launcher_background);
    textObjective.setText(getResources().getString(R.string.summry));
    }
}
