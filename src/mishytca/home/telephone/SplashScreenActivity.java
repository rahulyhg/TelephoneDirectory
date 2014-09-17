package mishytca.home.telephone;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity {
	 
    private static int SPLASH_SCREEN_TIMEOUT = 2000; // ������ �������� ���������� ���� 2000 ����������� (2 ������� ��� � �������)
 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        setContentView(R.layout.splash_screen);
 
        new Handler().postDelayed(new Runnable() { // ��������� ������� (����� ��������� ������������ ����)
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class); // �������� MainActivity ��������� ������ SplashScreen c � ������������� � ��� �������
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_TIMEOUT);
    }
 
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // ���������� ������ (�������� ������ ������ ���� � ����� ���������)
    }
 
}