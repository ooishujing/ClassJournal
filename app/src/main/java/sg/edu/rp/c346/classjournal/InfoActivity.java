package sg.edu.rp.c346.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Grade> al;
    GradeAdapter aa;
    Button btnINFO, btnAdd, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        lv = this.findViewById(R.id.lv);
        // get the intent
        Intent intent = getIntent();
        Grade grade = (Grade) intent.getSerializableExtra("newGrade");

        al.add(new Grade(1, "B"));
        al.add(new Grade(2, "C"));
        al.add(new Grade(3, "A"));
        al.add(grade);

        aa = new GradeAdapter(this, R.layout.row, al);
        lv.setAdapter((ListAdapter) aa);

        int numWeek = al.size() + 1;
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InfoActivity.this, AddActivity.class);
                i.putExtra("week", numWeek);
                startActivity(i);
            }
        });
    }
}