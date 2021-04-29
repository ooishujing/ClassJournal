package sg.edu.rp.c346.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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
    Button btnInfo, btnAdd, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        lv = this.findViewById(R.id.lv);
        btnAdd = findViewById(R.id.btnAdd);
        btnInfo = findViewById(R.id.btnInfo);
        btnEmail = findViewById(R.id.btnEmail);
        // get the intent
        Intent intent = getIntent();
        al = new ArrayList<>();

        al.add(new Grade(1, "B"));
        al.add(new Grade(2, "C"));
        al.add(new Grade(3, "A"));

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
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_TEXT,"Hi faci, \n\n" +
                        "I am ... \n" +
                        "Please see my remarks so far,thank you! \n" +
                        "");
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,"Choose an Email client :"));

            }
        });
    }
}