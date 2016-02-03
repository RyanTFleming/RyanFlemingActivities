package com.rytyf.ryanflemingactivities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SecondMessageActivity extends AppCompatActivity {

    private Intent intent;
    private String firstMessage;
    private String secondMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_message);
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

        intent = getIntent();
        firstMessage = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.messageOne);
        textView.setText(firstMessage);

        secondMessage = intent.getStringExtra(DisplayMessageActivity.SECOND_MESSAGE);
        TextView txtViewTwo = (TextView) findViewById(R.id.messageTwo);
        txtViewTwo.setText(secondMessage);

        if (textView.getText().equals("")) {
            textView.setText("No Message Sent");
            textView.setTextColor(Color.RED);
        }
        if (txtViewTwo.getText().equals("")) {
            txtViewTwo.setText("No Message Sent");
            txtViewTwo.setTextColor(Color.RED);
        }
    }

    /**
     * Returns the intent to the previous activity when navigating up
     *
     * @param item the up navigation button
     * @return true if clicked?
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpTo(this,intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
