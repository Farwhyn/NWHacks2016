package fourasians.translinkstopnote;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.StrictMath.round;
import static java.lang.String.format;

public class Computation extends AppCompatActivity {

    private List<Integer> estimatedTimes;
    private double estimatedTime;
    private List<Double> estimationErrors;
    private double estimationError;
    //ScrollView scrollview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computation);

        //scrollview = new ScrollView(this);
        //LinearLayout linearlayout = new LinearLayout(this);
        //linearlayout.setOrientation(LinearLayout.VERTICAL);
        //scrollview.addView(linearlayout);

        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setText("Estimated arrival time: " + format("%.2f", findEstimate()) + " mins. (Error: ±" + format("%.2f", findEstimateError()) + " mins)");
        //textView.setText("Enter Starting Station");

        //linearlayout.addView(textView);


        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setText("Estimated nap time: " + format("%.2f", findEstimateNap()) + " mins.");





//        LinearLayout linear1 = new LinearLayout(this);
//        linear1.setOrientation(LinearLayout.HORIZONTAL);
//        linearlayout.addView(linear1);
//        linear1.addView(textView);

        Button b = (Button) this.findViewById(R.id.button3);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Toast.makeText(getApplicationContext(), "User entered " + v.getId(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Computation.this, MainActivity.class);
                startActivity(i);
            }
        });



    }

    public double findEstimate() {
        estimatedTimes = Arrays.asList(1456677938, 1456677998, 1456678430, 1456678716, 1456678923, 1456679099,
                1456679271, 1456679451, 1456679541, 1456679750, 1456679930, 1456680111,
                1456680231);
        if (Destination.endId > BusStops.startId) {
            estimatedTime = (estimatedTimes.get(Destination.endId)
                    - estimatedTimes.get(BusStops.startId))/60.0;
        } else {
            estimatedTime = (estimatedTimes.get(BusStops.startId)
                    - estimatedTimes.get(Destination.endId))/60.0;
        }
        return estimatedTime;
    }

    public double findEstimateNap() {
        estimatedTimes = Arrays.asList(1456677938, 1456677998, 1456678430, 1456678716, 1456678923, 1456679099,
                1456679271, 1456679451, 1456679541, 1456679750, 1456679930, 1456680111,
                1456680231);
        if (Destination.endId > BusStops.startId) {
            estimatedTime = (estimatedTimes.get(Destination.endId-1)
                    - estimatedTimes.get(BusStops.startId))/60.0;
        } else {
            estimatedTime = (estimatedTimes.get(BusStops.startId)
                    - estimatedTimes.get(Destination.endId+1))/60.0;

        }
        return estimatedTime;
    }

    public double findEstimateError() {
        estimationErrors = Arrays.asList(0.000, 0.000, 1.889, 1.248, 1.167, 1.504, 0.598, 0.000, 1.586, 1.586, 1.889, 2.037
                ,1.830);
        if (Destination.endId > BusStops.startId) {
            List<Double> subset = estimationErrors.subList(BusStops.startId+1, Destination.endId);
            estimationError = 0.0;
            for (Double error : subset) {
                estimationError += error;
            }
        } else {
            List<Double> subset = estimationErrors.subList(Destination.endId+1, BusStops.startId);
            estimationError = 0.0;
            for (Double error : subset) {
                estimationError += error;
            }
        }
        return estimationError;
    }


}
