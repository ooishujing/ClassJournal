package sg.edu.rp.c346.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GradeAdapter extends ArrayAdapter<Grade> {

    private ArrayList<Grade> grade;
    private Context context;
    private TextView tvGrade, tvWeek;
    private ImageView ivDG;

    public GradeAdapter(Context context, int resource, ArrayList<Grade> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        grade = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);


        tvGrade = (TextView) rowView.findViewById(R.id.textViewGrade);
        tvWeek = (TextView) rowView.findViewById(R.id.textViewWeek);
        ivDG = (ImageView) rowView.findViewById(R.id.imageViewDG);

        Grade currentGrade = grade.get(position);

        tvGrade.setText(currentGrade.getGrade());
        tvWeek.setText(currentGrade.getWeek());
        ivDG.setImageResource(R.drawable.dg);

        return rowView;
    }
}