package com.rossia.life.androidutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.rossia.life.utillibrary.util.EmptyHandlerUtil;
import com.rossia.life.utillibrary.util.ToastUtil;

/**
 * @author pd_liu 2017/11/30.
 *         <p>
 *         编写测试页面.
 *         </p>
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
