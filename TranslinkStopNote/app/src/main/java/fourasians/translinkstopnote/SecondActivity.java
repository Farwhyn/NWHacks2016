package fourasians.translinkstopnote;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.app.ListActivity;
import android.widget.Button;
import android.graphics.Color;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecondActivity extends AppCompatActivity {

    ArrayList<String> testBusStop = new ArrayList<String>();
    Button b;
    ScrollView scrollview;
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (MainActivity.inputText == 99) {
            testBusStop.add("Cambie");
            testBusStop.add("Main");
            testBusStop.add("Arbutus");

            //scrollview = new ScrollView(this);
            LinearLayout linearlayout = new LinearLayout(this);
            scrollview = new ScrollView(this);
            linearlayout.setOrientation(LinearLayout.VERTICAL);
            scrollview.addView(linearlayout);

            for (int i = 0; i < testBusStop.size(); i++) {

                LinearLayout linear1 = new LinearLayout(this);
                linear1.setOrientation(LinearLayout.HORIZONTAL);
                linearlayout.addView(linear1);
                b = new Button(this);
                b.setText(testBusStop.get(i));
                //b.setBackgroundColor(Color.rgb(70, 80, 90));
                b.setId(i);
                b.setTextSize(10);
                b.setPadding(8, 3, 8, 3);
                b.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);
                b.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                linear1.addView(b);

                b.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "User chose " + v.getId(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
            this.setContentView(scrollview);
        } else {
            Intent i = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(i);
        }
    }
}