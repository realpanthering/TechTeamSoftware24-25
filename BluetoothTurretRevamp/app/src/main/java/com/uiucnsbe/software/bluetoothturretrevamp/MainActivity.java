package com.uiucnsbe.software.bluetoothturretrevamp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.database.Observable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Build;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Set;
import java.util.UUID;
import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CONNECT_THREAD";
    private static final int REQUEST_ENABLE_BLUETOOTH = 1;

    // Use handler to get BT connection status
    public static Handler handler;
    private static final int ERROR_READ = 0; // used in bluetooth handler to identify message update
    BluetoothDevice arduinoBTModule = null;
    // declare a default UUID to create global variable
    UUID arduinoUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
//    @RequiresApi(api = Build.VERSION_CODES.M)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // default code
        setContentView(R.layout.activity_main);
        // DEFAULT CODE
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        Intent intent = new Intent();
//        intent.putExtra("id", 0);

        // NEW CODE from bluetooth tutorial
        // Instances of BT Manager and Adapter needed to work with BT in Android
        // option 1: for supporting older apis? @link https://stackoverflow.com/a/74069658
//        BluetoothManager BTManager = (BluetoothManager) getSystemService(BluetoothManager.class);
        // option 2: targeting higher apis (23+)
        BluetoothManager BTManager = (BluetoothManager) getSystemService(BLUETOOTH_SERVICE);
        BluetoothAdapter BTAdapter = BTManager.getAdapter();

        // Instances of the Android UI elements that will be used during execution
        TextView btReadings = findViewById(R.id.btReadings);
        TextView btDevices = findViewById(R.id.btDevices);
        Button connectToDevice = (Button) findViewById(R.id.connectToDevice);
        Button searchForDevices = (Button) findViewById(R.id.searchForDevices);
        Button clearValues = (Button) findViewById(R.id.refresh);
        Log.d(TAG, "BEGIN EXECUTION");


        // Using a handler to update the interface in case of an error while connecting to the BT device
        // Idea: show handler vs RxAndroid
        handler = new Handler() {
            @Override
            public void publish(LogRecord record) {

            }

            @Override
            public void flush() {

            }

            @Override
            public void close() throws SecurityException {

            }

            public void handleMessage(Message msg) {
                if (msg.what == ERROR_READ) {
                    String arduinoMsg = msg.obj.toString(); // Read message from Arduino
                    btReadings.setText(arduinoMsg);
                }
            }
        };

        // Set a listener event on a button to clear the texts
        clearValues.setOnClickListener(v -> {
            btReadings.setText("");
            btDevices.setText("");
        });

        // Create an Observable from RxAndroid
        //The code will be executed when an Observer subscribes to the the Observable
        final Observable<String> connectToBTObservable = new Observable<String>() {
            @Override
            public void registerObserver(String observer) {
                super.registerObserver(observer);
            }
        };
    }
}