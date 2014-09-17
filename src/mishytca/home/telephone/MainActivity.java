package mishytca.home.telephone;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {
	
	SharedPreferences sp;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main); // вешаем layout на Activity
		 
		// получаем SharedPreferences, которое работает с файлом настроек
	    sp = PreferenceManager.getDefaultSharedPreferences(this);
	    
	    
	}
	
    protected void onResume() {
       //метод для выовда обработки "настроек" пока не используется
        super.onResume();
      }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) { // создаём меню ActionBar с пунктами из menu/vain.xml
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) { // обрабатываем нажатия на кнопки в ActionBar
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
	       switch (item.getItemId())
	        {
	        case R.id.Add:
	        	Intent intent = new Intent(this, AddActivity.class);
				startActivity(intent);
				 return super.onOptionsItemSelected(item);
	        case R.id.Settings:
	        	Intent intent2 = new Intent(this, PrefActivity.class);
				startActivity(intent2);
				 return super.onOptionsItemSelected(item);
	        case R.id.Export_impotr:
	        	Intent intent3 = new Intent(this, ExpImpActivity.class);
				startActivity(intent3);
				 return super.onOptionsItemSelected(item);
	        }
			return false;
			
	    }
	}	 