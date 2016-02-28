package fourasians.translinkstopnote;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
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

        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText("Estimated arrival time: " + findEstimate() + " mins");
        //textView.setText("Enter Starting Station");

        //linearlayout.addView(textView);





//        LinearLayout linear1 = new LinearLayout(this);
//        linear1.setOrientation(LinearLayout.HORIZONTAL);
//        linearlayout.addView(linear1);
//        linear1.addView(textView);



    }

    public double findEstimate() {
        estimatedTimes = Arrays.asList(1456672950, 1456673010, 1456673148, 1456673310, 1456673430,
                1456673508,1456673688, 1456673868, 1456673988, 1456674228, 1456674486, 1456674846,
                1456674966);
        if (Destination.endId > BusStops.startId) {
            estimatedTime = (estimatedTimes.get(Destination.endId)
                    - estimatedTimes.get(BusStops.startId))/60.0;
        } else {
            estimatedTime = estimatedTimes.get(BusStops.startId)
                    - estimatedTimes.get(Destination.endId)/60.0;

        }
        return estimatedTime;
    }

}
