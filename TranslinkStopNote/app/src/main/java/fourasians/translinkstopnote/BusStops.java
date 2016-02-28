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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BusStops extends AppCompatActivity {

    //private int bus = 99;
    private Set<Integer> buses = new HashSet<>();

    private List<String> testBusStops = new ArrayList<>();
    private List<String> testBusStops41 = new ArrayList<>();
    private List<String> testBusStops84 = new ArrayList<>();

    Button b;
    ScrollView scrollview;

    public static int startId;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startId = 0;

        scrollview = new ScrollView(this);
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setOrientation(LinearLayout.VERTICAL);
        scrollview.addView(linearlayout);

        //his function, returns Set
        // buses = his set
        buses.add(1);
        buses.add(2);
        //buses.add(3);
        //buses.add(99);

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
        if (buses.contains(input)) {
            WindowManager.LayoutParams param = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
            TextView textView = new TextView(this);
            textView.setLayoutParams(param);
            textView.setText("Enter Starting Station");
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
                            //Toast.makeText(getApplicationContext(), "User entered " + v.getId(), Toast.LENGTH_SHORT).show();
                            startId = v.getId();
                            Intent i = new Intent(BusStops.this, Destination.class);
                            startActivity(i);
                        }
                    });
                }
                this.setContentView(scrollview);
                }



        } else {
            Intent i = new Intent(BusStops.this, MainActivity.class);
            startActivity(i);

        }
    }
}