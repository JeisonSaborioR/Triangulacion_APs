package com.example.jeison.triangulacion_aps;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button toDashboard;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Access Point Main");

        toDashboard = (Button) findViewById(R.id.triangular);
        toDashboard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.triangular:
                intent = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(intent);
                break;
        }
    }
}
