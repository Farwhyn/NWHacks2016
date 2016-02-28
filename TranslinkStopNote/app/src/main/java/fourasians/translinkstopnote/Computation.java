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

public class Computation extends AppCompatActivity {

    private List<Integer> estimatedTimes;
    private double estimatedTime;
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
        textView4.setText("Estimated arrival time: " + findEstimate() + " mins");
        //textView.setText("Enter Starting Station");

        //linearlayout.addView(textView);


        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setText("Estimated nap time: " + findEstimateNap() + " mins");



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
        estimatedTimes = Arrays.asList(1456672950, 1456673010, 1456673148, 1456673310, 1456673430,
                1456673508,1456673688, 1456673868, 1456673988, 1456674228, 1456674486, 1456674846,
                1456674966);
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
        estimatedTimes = Arrays.asList(1456672950, 1456673010, 1456673148, 1456673310, 1456673430,
                1456673508,1456673688, 1456673868, 1456673988, 1456674228, 1456674486, 1456674846,
                1456674966);
        if (Destination.endId > BusStops.startId) {
            estimatedTime = (estimatedTimes.get(Destination.endId-1)
                    - estimatedTimes.get(BusStops.startId))/60.0;
        } else {
            estimatedTime = (estimatedTimes.get(BusStops.startId)
                    - estimatedTimes.get(Destination.endId+1))/60.0;

        }
        return estimatedTime;
    }


}
