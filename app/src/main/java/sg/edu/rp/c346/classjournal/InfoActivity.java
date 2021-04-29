package sg.edu.rp.c346.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.net.Uri;
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
    Button btnInfo, btnAdd, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        lv = this.findViewById(R.id.lv);
        btnAdd = findViewById(R.id.btnAdd);
        btnInfo = findViewById(R.id.btnInfo);
        btnEmail = findViewById(R.id.btnEmail);

        al = new ArrayList();

        al.add(new Grade(1, "B"));
        al.add(new Grade(2, "C"));
        al.add(new Grade(3, "A"));

        //al.add(grade);

        aa = new GradeAdapter(this, R.layout.row, al);
        lv.setAdapter(aa);

        int numWeek = al.size()+1;

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InfoActivity.this, AddActivity.class);
                i.putExtra("week", numWeek);
                startActivityForResult(i,requestCodes);


            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.rp.edu.sg/"));
                startActivity(intent);
            }
        });
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                String emaildata = "";
                for (int i = 0; i <al.size(); i++){
                    emaildata +="Week "+al.get(i).getWeek()+ "DG: "+al.get(i).getGrade()+"\n";
                }
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_TEXT,"Hi faci, \n\n" +
                        "I am ... \n" +
                        "Please see my remarks so far,thank you! \n" +
                        emaildata);
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,"Choose an Email client :"));

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

                Grade newGrade = (Grade) data.getSerializableExtra("newGrade");
               

               al.add(new Grade(newGrade.getWeek(),newGrade.getGrade()));


               aa.notifyDataSetChanged();


            }
        }
    }


}