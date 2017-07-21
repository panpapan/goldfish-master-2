package com.example.sakamotoaya.goldfish_1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Game.this, Stop.class);
                startActivity(intent);
            }
        }, 30000);

        // ボタンを設定
        Button button = (Button)findViewById(R.id.tap);

        // TextView の設定
        textView = (TextView) findViewById(R.id.textView);

        // リスナーをボタンに登録
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Hello");
            }
        });

        // 10秒カウントダウンする
        new CountDownTimer(30000,1000){
            TextView count_txt = (TextView)findViewById(R.id.textView2);
            // カウントダウン処理
            public void onTick(long millisUntilFinished){
                count_txt.setText(millisUntilFinished/1000+"秒");
            }
            // カウントが0になった時の処理
            public void onFinish(){
                count_txt.setText("タイムオーバー");
            }
        }.start();

    }

}