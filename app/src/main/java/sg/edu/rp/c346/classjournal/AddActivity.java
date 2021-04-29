package sg.edu.rp.c346.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    TextView tvWeek;
    int weeks = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        tvWeek = findViewById(R.id.tvWeek);
        //Set tvWeek from get intent
        Intent geti = getIntent();
        weeks = geti.getIntExtra("week", 0);
        tvWeek.setText("Weeks "+ weeks);


        // btnsubmit
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // GET selected radio button info
                RadioGroup rg = (RadioGroup) findViewById(R.id.rgGrade);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);


                String grade = String.valueOf(rb.getText());

                Grade newGrade = new Grade(weeks,grade);



                Intent i = new Intent();
                i.putExtra("newGrade", newGrade);
                setResult(RESULT_OK, i);
                finish();

            }
        });



    }
}