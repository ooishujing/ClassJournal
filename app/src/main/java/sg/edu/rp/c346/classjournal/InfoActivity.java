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
import android.widget.Toast;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Grade> al;
    GradeAdapter aa;
    int requestCodes = 1;
    Button btnINFO, btnAdd, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        lv = this.findViewById(R.id.lv);
        btnAdd = findViewById(R.id.btnAdd);

        // get the intent
        Intent intent = getIntent();
        Grade grade = (Grade) intent.getSerializableExtra("newGrade");

        ArrayList al = new ArrayList();

        al.add(new Grade(1, "B"));
        al.add(new Grade(2, "C"));
        al.add(new Grade(3, "A"));
        //al.add(grade);

        aa = new GradeAdapter(this, R.layout.row, al);
        lv.setAdapter((ListAdapter) aa);

        int numWeek = al.size() + 1;

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InfoActivity.this, AddActivity.class);
                //i.putExtra("week", numWeek);
                startActivityForResult(i,requestCodes);


            }
        });

    }
    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if (resultCode == RESULT_OK) {
            if (data != null) {
                // Get data passed back from 2nd activity
                Grade newGrade = data.getSerializableExtra("newGrade");

               //al.add(newWeek,newGrade);

                Toast.makeText(InfoActivity.this, newGrade + newWeek,
                        Toast.LENGTH_LONG).show();

            }
        }
    }


}