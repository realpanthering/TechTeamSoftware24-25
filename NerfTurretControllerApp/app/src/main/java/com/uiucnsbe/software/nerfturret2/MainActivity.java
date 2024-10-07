package com.uiucnsbe.software.nerfturret2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast; // For displaying simple messages
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Your XML layout file

        // Find buttons by their IDs from activity_main.xml
        Button upButton = findViewById(R.id.button_up);
        Button downButton = findViewById(R.id.button_down);
        Button leftButton = findViewById(R.id.button_left);
        Button rightButton = findViewById(R.id.button_right);
        Button shootButton = findViewById(R.id.button_shoot);

        // Add button listeners
        upButton.setOnClickListener(v -> {
            // Handle up button click
            Toast.makeText(MainActivity.this, "Up button clicked", Toast.LENGTH_SHORT).show();
            // Add your turret control logic here
        });

        downButton.setOnClickListener(v -> {
            // Handle down button click
            Toast.makeText(MainActivity.this, "Down button clicked", Toast.LENGTH_SHORT).show();
        });

        leftButton.setOnClickListener(v -> {
            // Handle left button click
            Toast.makeText(MainActivity.this, "Left button clicked", Toast.LENGTH_SHORT).show();
        });

        rightButton.setOnClickListener(v -> {
            // Handle right button click
            Toast.makeText(MainActivity.this, "Right button clicked", Toast.LENGTH_SHORT).show();
        });

        shootButton.setOnClickListener(v -> {
            // Handle shoot button click
            Toast.makeText(MainActivity.this, "Shoot button clicked", Toast.LENGTH_SHORT).show();
        });
    }
}
