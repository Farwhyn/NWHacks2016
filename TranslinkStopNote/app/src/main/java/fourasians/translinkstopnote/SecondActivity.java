package fourasians.translinkstopnote;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.app.ListActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecondActivity extends AppCompatActivity {

    private int bus = 99;
    private Set<Integer> buses = new HashSet<>();

    private List<String> testBusStops = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //his function, returns Set
        // buses = his set
        buses.add(1);
        buses.add(2);
        buses.add(3);
        buses.add(99);

        testBusStops.add("Main");
        testBusStops.add("Cambie");
        testBusStops.add("Arbutus");


        Log.d("TAG", Integer.toString(MainActivity.inputText));
        int input = MainActivity.inputText;
        if (buses.contains(input)) {
            //go to the next proper activity
            //getStops(input); -> returns list of stops;

            // get the bus
            //need to make sure bus has list of string
            for (String stop : testBusStops) {
                //create button in
            }

        } else {
            //go back
            Intent i = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(i);

        }

            //do shit

    }

}