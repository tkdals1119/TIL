package com.example.userinsight.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SensorManager manager;
    private Sensor accSensor;

    private View mLayout;
    private float mX, mY;

    private Kalman mKalmanAccX;
    private Kalman mKalmanAccY;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 움직일 오브젝트(뷰객체)가 있는 부모 레이아웃
        mLayout = this.findViewById(R.id.Layout);

        // 칼만필터 초기화
        mKalmanAccX = new Kalman(0.0f);
        mKalmanAccY = new Kalman(0.0f);

        // 기울기 센서 등록
        manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accSensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        manager.registerListener(sel, accSensor, SensorManager.SENSOR_DELAY_GAME);
    }

    private SensorEventListener sel = new SensorEventListener()
    {

        @Override
        public void onSensorChanged(SensorEvent event)
        {
            float x = event.values[0];
            float y = event.values[1];


            float filteredX = 0.0f;
            float filteredY = 0.0f;
            // 칼만필터를 적용한다
            filteredX = (float) mKalmanAccY.update(x);
            filteredY = (float) mKalmanAccX.update(y);

            // 이 주석을 풀면 칼만필터를 사용하지 않는다
            // filteredX = x;
            // filteredY = y;
            // 부모 레이아웃을 스크롤시켜 마치 뷰객체(오브젝트)가 움직이는것처럼 보이게 한다
            // 저장해둔 예전값과 현재값의 차를 넣어 변화를 감지한다
            // 여기에 100을 곱하는것은 차의 숫자가 워낙 작아 움직임이 보이지 않기 때문이다.
            // 즉, 스피드라고도 보면 된다ㅎㅎ 더 큰숫자를 넣으면 더 빠르게 움직인다.
            mLayout.scrollBy((int) ((mX - filteredX) * 100), -(int) ((mY - filteredY) * 100));

            // 예전값을 저장한다
            mX = filteredX;
            mY = filteredY;
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy)
        {
        }
    };

    @Override
    protected void onResume()
    {
        manager.registerListener(sel, accSensor, SensorManager.SENSOR_DELAY_GAME);
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        manager.unregisterListener(sel);
        super.onPause();
    }
}
