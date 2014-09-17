package mishytca.home.telephone;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBase<DBHelper> {
	
	  private static final String DB_NAME = "mydb";
	  private static final int DB_VERSION = 1;
	  private static final String DB_TABLE = "mytab";
	  
	  public static final String COLUMN_ID = "_id";
	  public static final String COLUMN_IMG = "img";
	  public static final String COLUMN_NAME = "Name";
	  public static final String COLUMN_SURNAME = "Surname";
	  public static final String COLUMN_BIRTH = "Date Of Birth";
	  public static final String COLUMN_SEX = "Sex";
	  public static final String COLUMN_ADRESS = "Adress";
	  public static final String COLUMN_TEL = "Tel";
	  
	  private static final String DB_CREATE = 
			  "create table " + DB_TABLE + "(" +
			    COLUMN_ID + " integer primary key autoincrement, " +
			    COLUMN_IMG + " integer, " +
			    COLUMN_NAME + " Name, " +
			    COLUMN_SURNAME + " Surname, " + 
			    COLUMN_BIRTH + " Date Of Birth, " +
			    COLUMN_SEX + " Sex, " +
			    COLUMN_ADRESS + " Adress, " +
			    COLUMN_TEL + " Tel" +
			  ");";

private final Context mCtx;


private DBHelper mDBHelper;
private SQLiteDatabase mDB;

public DataBase(Context ctx) {
  mCtx = ctx;
}

//открыть подключение
public void open() {
 mDBHelper = new DBHelper(mCtx, DB_NAME, null, DB_VERSION);
 mDB = mDBHelper.getWritableDatabase();
}
// закрыть подключение
public void close() {
  if (mDBHelper!=null) mDBHelper.close();
}
// получить все данные из таблицы DB_TABLE
public Cursor getAllData() {
  return mDB.query(DB_TABLE, null, null, null, null, null, null);
}
//добавить запись в DB_TABLE
public void addRec(String name, String surname, String birth, String sex, String adress,  String tel, int img) {
 ContentValues cv = new ContentValues();
 cv.put(COLUMN_NAME, name);
 cv.put(COLUMN_SURNAME, surname);
 cv.put(COLUMN_BIRTH, birth);
 cv.put(COLUMN_SEX, sex);
 cv.put(COLUMN_ADRESS, adress);
 cv.put(COLUMN_TEL, tel);
 cv.put(COLUMN_IMG, img);
 mDB.insert(DB_TABLE, null, cv);
}
//удалить запись из DB_TABLE
public void delRec(long id) {
 mDB.delete(DB_TABLE, COLUMN_ID + " = " + id, null);
}

//класс по созданию и управлению БД
private class DBHelper extends SQLiteOpenHelper {

 public DBHelper(Context context, String name, CursorFactory factory,
     int version) {
   super(context, name, factory, version);
 }
//создаем и заполняем БД
 @Override
 public void onCreate(SQLiteDatabase db) {
   db.execSQL(DB_CREATE);
   
   ContentValues cv = new ContentValues();
   for (int i = 1; i < 10; i++) {
	 cv.put(COLUMN_ADRESS, + i);
	 cv.put(COLUMN_ADRESS, + i);
	 cv.put(COLUMN_SEX, + i);
	 cv.put(COLUMN_BIRTH, + i);
	 cv.put(COLUMN_SURNAME, + i);  
     cv.put(COLUMN_NAME, + i);
     cv.put(COLUMN_IMG, R.drawable.add_photo);
     db.insert(DB_TABLE, null, cv);
   }
 }
 @Override
 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 }
}

}