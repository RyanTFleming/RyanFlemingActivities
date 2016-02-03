package com.rytyf.ryanflemingactivities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    public final static String SECOND_MESSAGE = "com.rytyf.ryanflemingactivity.MESSAGE";
    private String firstMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        Intent intent = getIntent();
        firstMessage = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.txtMessage1);
        textView.setText(firstMessage);
        if (textView.getText().equals("")) {
            textView.setText("No Message Sent");
            textView.setTextColor(Color.RED);
        }
    }

    /**
     * Action performed when the button is clicked.
     * Sends creates an intent containing the two messages that have
     * been entered.
     *
     * @param view - the button clicked
     */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, SecondMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.txtMessage2);
        String secondMessage = editText.getText().toString();
        intent.putExtra(MainActivity.EXTRA_MESSAGE, firstMessage);
        intent.putExtra(SECOND_MESSAGE, secondMessage);
        startActivity(intent);
    }
}
