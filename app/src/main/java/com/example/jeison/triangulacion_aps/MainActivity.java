package com.example.jeison.triangulacion_aps;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    //Declaración de las variables
    Button toDashboard;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    ArrayAdapter<String> arrayA1, arrayA2, aaArray3;


    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Access Point Main");

        toDashboard = (Button) findViewById(R.id.triangular);



        //Inicializar los spinners de access points
        spinner1 = (Spinner) findViewById(R.id.primerAccessPoint);
        spinner2 = (Spinner) findViewById(R.id.segundoAccessPoint);
        spinner3 =  (Spinner) findViewById(R.id.tercerAccessPoint);


        toDashboard.setOnClickListener(this);

    }


    //Iniciar la vista dashboard a partir del boton
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.triangular:
                intent = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(intent);
                break;
        }
    }

    //Cargar los access points desponibles con un 95% de señal
    public void loadAccessPoints(Context ctxt){

        List<String> namesAccessPoints = new ArrayList<String>();


        //Level of a ScanResult
        WifiManager wifiManager = (WifiManager) ctxt.getSystemService(Context.WIFI_SERVICE);
        wifiManager.startScan();

        List<ScanResult> accessPointList = wifiManager.getScanResults();

        for (ScanResult scanResult: accessPointList){
            namesAccessPoints.add(scanResult.SSID);
        }

        arrayA1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,namesAccessPoints);
        arrayA1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    }
}
