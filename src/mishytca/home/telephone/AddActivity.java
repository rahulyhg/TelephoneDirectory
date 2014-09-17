package mishytca.home.telephone;



import java.io.File;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
public class AddActivity extends Activity 
{
    File directory;
	final int TYPE_PHOTO = 1;
	final int REQUEST_CODE_PHOTO = 1;
	static final int GALLERY_REQUEST = 2;
	ImageButton imbutton;
	  
	public static final int IDM_PHOTO = 101; 
	public static final int IDM_GALLARY = 102; 
	public static final int IDM_INTERNET = 103; 
	
	

	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        
        imbutton = (ImageButton)findViewById(R.id.btnAdd);
        
        
        registerForContextMenu(imbutton); 
   

        
      }          
     
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) 
	{
		super.onCreateContextMenu(menu, v, menuInfo);
		// программное добавление меню
		menu.add(Menu.NONE, IDM_PHOTO, Menu.NONE, "Сфотографировать");
		menu.add(Menu.NONE, IDM_GALLARY, Menu.NONE, "Выбрать из галереи");
		menu.add(Menu.NONE, IDM_INTERNET, Menu.NONE, "Загрузить из сети");
		
//		MenuInflater inflater = getMenuInflater();
//		inflater.inflate(R.menu.context_menu, menu);
	}
	
	
	@Override
	  protected void onActivityResult(int requestCode, int resultCode,
	      Intent imageReturnedIntent) {
	    if (requestCode == REQUEST_CODE_PHOTO) {
	      if (resultCode == RESULT_OK) {
	        if (imageReturnedIntent == null) {
	                  } else {
	         
	          Bundle bndl = imageReturnedIntent.getExtras();
	          if (bndl != null) {
	            Object obj = imageReturnedIntent.getExtras().get("data");
	            if (obj instanceof Bitmap) {
	              Bitmap bitmap = (Bitmap) obj;
	              imbutton.setImageBitmap(bitmap);
	            }
	          }
	        }
	      } else if (resultCode == RESULT_CANCELED) {
	        
	      }
	    }
	    Bitmap bitmap = null;
	    switch(requestCode) { 
	    case GALLERY_REQUEST:
	        if(resultCode == RESULT_OK){  
	            Uri selectedImage = imageReturnedIntent.getData();
	            imbutton.setImageURI(selectedImage);
	            imbutton.setImageBitmap(bitmap);
	        }
	    }
	    
	    
      }
	@Override
	public boolean onContextItemSelected(MenuItem item) 
	{
		CharSequence message;
		switch (item.getItemId()) 
		{
		    case IDM_PHOTO:
		    	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			    //intent.putExtra(MediaStore.EXTRA_OUTPUT, generateFileUri(TYPE_PHOTO));
			    startActivityForResult(intent, REQUEST_CODE_PHOTO);
			    message = "Сфотографировать";
			    break;
		    case IDM_GALLARY:
		    	Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
				photoPickerIntent.setType("image/*");
				startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
			    message = "Выбрать из галереи";
			    break;
		    case IDM_INTERNET:
			    message = "Загрузить из сети";
			    break;			    
		    default:
			    return super.onContextItemSelected(item);
		}
		Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
		return true;
	}   
}