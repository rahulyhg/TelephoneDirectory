package mishytca.home.telephone;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity {
	 
    private static int SPLASH_SCREEN_TIMEOUT = 2000; // задаем отсрочку выполнения кода 2000 миллисекунд (2 секунды как в задании)
 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        setContentView(R.layout.splash_screen);
 
        new Handler().postDelayed(new Runnable() { // использую хендлер (задаю временную приостановку кода)
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class); // стартуем MainActivity завершаем работу SplashScreen c с приостановкой в две секунды
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_TIMEOUT);
    }
 
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // ориентация экрана (завтавка всегда должна быть в одном положении)
    }
 
}