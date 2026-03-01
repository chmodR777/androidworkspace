package com.example.jniaddsdk;

import com.example.addsdk.NativeAddUtils;

import android.os.Bundle;

import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;

public class MainActivity extends AppCompatActivity {

    // 定义TAG常量，用于日志标记
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        // 1. 获取TextView用于显示结果
        TextView tvResult = findViewById(R.id.tv_result);

        // 2. 调用SDK的add方法
        int a = 10;
        int b = 50000;
        // 方式1：创建对象调用
        NativeAddUtils addUtils = new NativeAddUtils();
        int result1 = addUtils.add(a, b);
        // 方式2：调用静态封装方法
        int result2 = NativeAddUtils.calculateAdd(a, b);

        // 3. 打印日志并显示结果
        Log.d(TAG, "a=" + a + ", b=" + b + ", 相加结果1：" + result1);
        Log.d(TAG, "a=" + a + ", b=" + b + ", 相加结果2：" + result2);
        tvResult.setText("10 + 20 = " + result1);


    }
}