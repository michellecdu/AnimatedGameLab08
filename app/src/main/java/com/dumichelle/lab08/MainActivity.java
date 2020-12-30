package com.dumichelle.lab08;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawView=findViewById(R.id.DrawView);
    }

    public void moveLeft(View view) {
        DrawView.sprite.setdX(-8);//set horizontal speed to move left
    }

    public void moveRight(View view) {
        DrawView.sprite.setdX(8);//set horizontal speed to move right
    }

}