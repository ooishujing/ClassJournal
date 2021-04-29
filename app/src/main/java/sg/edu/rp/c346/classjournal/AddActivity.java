package sg.edu.rp.c346.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // GET selected radio button info
        RadioGroup rg = (RadioGroup)findViewById(R.id.rgGrade);
        int selectedButtonId = rg.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton)findViewById(selectedButtonId);
        String grade = String.valueOf(rb.getText());

        //Set tvWeek from get intent
        Intent geti = getIntent();
        int week = geti.getIntExtra("week",0);

        //Creating new Grade object
        Grade newGrade = new Grade(week,grade);

        // btnsubmit
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("newGrade",newGrade);
                setResult(RESULT_OK, i);
                finish();
            }
        });
        

    }
}