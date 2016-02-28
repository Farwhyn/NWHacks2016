package fourasians.translinkstopnote;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int userInput = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Button b = (Button) this.findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {

                                 @Override
                                 public void onClick(View v) {
                                     int bus = scanf(text);
                                     Intent i = new Intent(MainActivity.this, SecondActivity.class);

                                         startActivity(i);

                                     }

                                 }
                             }
        );
        */

        EditText editBus = (EditText) findViewById(R.id.editText);
        editBus.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int input, KeyEvent keyEvent) {
                boolean handled = false;
                if (input == EditorInfo.IME_ACTION_DONE) {
                    //show something?
                    int inputText = Integer.parseInt(textView.getText().toString());
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(i);
                }
                return false;
            }
        });


    }

}
