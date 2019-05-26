package com.shlmlkzdh.bulletprogressbar.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.shlmlkzdh.bulletprogressbar.BulletProgressBar;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    BulletProgressBar bulletProgressBar;
    Button btnBackgroundColor;
    Button btnBulletColor;
    Button btnBorderWidth;
    Button btnShadowRadius;
    Button btnLength;
    Button btnProgress;
    Button btnIncrease;
    Button btnIncreaseRed;
    Button btnIncreaseGreen;
    Button btnDecrease;
    Button btnLine;
    EditText etBackgroundColor;
    EditText etBulletColor;
    EditText etBorderWidth;
    EditText etShadowRadius;
    EditText etLength;
    EditText etProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bulletProgressBar = (BulletProgressBar)findViewById(R.id.bpb);

        btnBackgroundColor = (Button)findViewById(R.id.btn_background_color);
        btnBackgroundColor.setOnClickListener(this);
        btnBulletColor = (Button)findViewById(R.id.btn_bullet_color);
        btnBulletColor.setOnClickListener(this);
        btnBorderWidth = (Button)findViewById(R.id.btn_border_width);
        btnBorderWidth.setOnClickListener(this);
        btnShadowRadius = (Button)findViewById(R.id.btn_shadow_radius);
        btnShadowRadius.setOnClickListener(this);
        btnLength = (Button)findViewById(R.id.btn_length);
        btnLength.setOnClickListener(this);
        btnProgress = (Button)findViewById(R.id.btn_progress);
        btnProgress.setOnClickListener(this);
        btnIncrease = (Button)findViewById(R.id.btn_increase);
        btnIncrease.setOnClickListener(this);
        btnIncreaseRed = (Button)findViewById(R.id.btn_increase_red);
        btnIncreaseRed.setOnClickListener(this);
        btnIncreaseGreen = (Button)findViewById(R.id.btn_increase_green);
        btnIncreaseGreen.setOnClickListener(this);
        btnDecrease = (Button)findViewById(R.id.btn_decrease);
        btnDecrease.setOnClickListener(this);
        btnLine = (Button)findViewById(R.id.btn_line);
        btnLine.setOnClickListener(this);
        etBackgroundColor = (EditText)findViewById(R.id.et_background_color);
        Log.d(TAG, "onCreate: background color= " + bulletProgressBar.getBulletBackgroundColor() +
                ", bullet color= " + bulletProgressBar.getBulletColor());
        etBackgroundColor.setHint((((Integer)bulletProgressBar.getBulletBackgroundColor()).toString()));
        etBulletColor = (EditText)findViewById(R.id.et_bullet_color);
        etBulletColor.setHint((((Integer)bulletProgressBar.getBulletColor()).toString()));
        etBorderWidth = (EditText)findViewById(R.id.et_border_width);
        etShadowRadius = (EditText)findViewById(R.id.et_shadow_radius);
        etLength = (EditText)findViewById(R.id.et_length);
        etProgress = (EditText)findViewById(R.id.et_progress);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_background_color:
                bulletProgressBar.setBulletBackgroundColor(Integer.parseInt(etBackgroundColor.getText().toString()));
                break;
            case R.id.btn_bullet_color:
                bulletProgressBar.setBulletColor(Integer.parseInt(etBulletColor.getText().toString()));
                break;
            case R.id.btn_border_width:
                bulletProgressBar.setBorderWidth(Integer.parseInt(etBorderWidth.getText().toString()));
                break;
            case R.id.btn_shadow_radius:
                bulletProgressBar.setShadowRadius(Integer.parseInt(etShadowRadius.getText().toString()));
                break;
            case R.id.btn_length:
                if(Integer.parseInt(etLength.getText().toString()) < bulletProgressBar.getProgress()){
                    bulletProgressBar.setProgress(Integer.parseInt(etLength.getText().toString()));
                }
                bulletProgressBar.setLength(Integer.parseInt(etLength.getText().toString()));
                break;
            case R.id.btn_progress:
                bulletProgressBar.setProgress(min((Integer.parseInt(etProgress.getText().toString())),
                        bulletProgressBar.getLength()));
                break;
            case R.id.btn_increase:
                bulletProgressBar.increase();
                break;
            case R.id.btn_increase_red:
                bulletProgressBar.increaseWithColor(Color.RED);
                break;
            case R.id.btn_increase_green:
                bulletProgressBar.increaseWithColor(Color.GREEN);
                break;
            case R.id.btn_decrease:
                bulletProgressBar.decrease();
                break;
            case R.id.btn_line:
                bulletProgressBar.setLine(!bulletProgressBar.getLine());
        }

    }
}
