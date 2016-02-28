package fourasians.translinkstopnote;

import android.content.Intent;
import android.graphics.Typeface;
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
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.StrictMath.abs;

public class Destination extends AppCompatActivity {

    //private int bus = 99;

    private List<String> testBusStops = new ArrayList<>();
    Button b;
    ScrollView scrollview;

    public static int endId;


    private List<Integer> estimatedTimes;
    private double estimatedTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        endId = 0;

        scrollview = new ScrollView(this);
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setOrientation(LinearLayout.VERTICAL);
        scrollview.addView(linearlayout);

        //his function, returns Set
        // buses = his set


        testBusStops.add("Commercial Dr");
        testBusStops.add("Clark Dr");
        testBusStops.add("Fraser St");
        testBusStops.add("Main St");
        testBusStops.add("Cambie St");
        testBusStops.add("Heather St");
        testBusStops.add("Granville St");
        testBusStops.add("Arbutus St");
        testBusStops.add("MacDonald St");
        testBusStops.add("Alma St");
        testBusStops.add("Sasamat St");
        testBusStops.add("Allison Rd");
        testBusStops.add("UBC Loop Bay 6");

        int input = MainActivity.inputText;
            WindowManager.LayoutParams param = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
            TextView textView = new TextView(this);
            textView.setLayoutParams(param);
            textView.setText("Enter Target Station");
            textView.setTextSize(30);
            textView.setX(130);

            for(int i = -1; i<testBusStops.size();i++)
            {
                LinearLayout linear1 = new LinearLayout(this);
                linear1.setOrientation(LinearLayout.HORIZONTAL);
                linearlayout.addView(linear1);

                if(i == -1)
                {
                    linear1.addView(textView);
                }
                else {
                    b = new Button(this);
                    b.setText(testBusStops.get(i));
                    b.setId(i);
                    b.setTextSize(20);
                    //b.setPadding(20, 20, 20, 20);
                    b.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);
                    b.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                    b.setHeight(200);
                    b.setWidth(600);
                    b.setX(250);
                    linear1.addView(b);
                    b.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            endId = v.getId();
                            if (endId == BusStops.startId) {
                                Toast.makeText(getApplicationContext(), "Station did not change", Toast.LENGTH_SHORT).show();
                                Intent j = new Intent(Destination.this, BusStops.class);
                                startActivity(j);
                            } else if (abs(endId - BusStops.startId) == 1) {
                                // Dont sleep
                                Intent k = new Intent(Destination.this, NoSleep.class);
                                startActivity(k);
                            } else {
                                Intent i = new Intent(Destination.this, Computation.class);
                                startActivity(i);
                            }
                        }
                    });
                }
                this.setContentView(scrollview);
            }




    }
}