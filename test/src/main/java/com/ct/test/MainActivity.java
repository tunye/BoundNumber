package com.ct.test;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.ct.boundnumber.RiseNumberTextView;

public class MainActivity extends Activity {

    private RiseNumberTextView number1, number2, number3, number4, number5;
    private Button start;
    View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (v == start) {
                initData();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        number1 = (RiseNumberTextView) findViewById(R.id.number1);
        number2 = (RiseNumberTextView) findViewById(R.id.number2);
        number3 = (RiseNumberTextView) findViewById(R.id.number3);
        number4 = (RiseNumberTextView) findViewById(R.id.number4);
        number5 = (RiseNumberTextView) findViewById(R.id.number5);
        start = (Button) findViewById(R.id.start);

        start.setOnClickListener(listener);
    }

    private void initData() {
        number1.withNumber(1112.3f).start();
        number2.withNumber(546316.3f, false).start();
        number3.withNumber(10.3f).start();
        number4.withNumber(18).start();
        number5.withNumber(1111231213).setDuration(500).start();
        number5.setOnEnd(new RiseNumberTextView.EndListener() {
            @Override
            public void onEndFinish() {
                Toast.makeText(MainActivity.this, number5.getText() + "is faster!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
