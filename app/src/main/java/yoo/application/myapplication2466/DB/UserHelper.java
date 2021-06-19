package yoo.application.myapplication2466.DB;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import yoo.application.myapplication2466.DB.UserContract.UserEntry;
import yoo.application.myapplication2466.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;


    private static final String DATABASE_NAME = "User.db";

    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";


        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert the values into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Ram Kumar', 'ramk12@gmail.com','758456','785469127', 20000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Shyam Gopal', 'shyamg@gmail.com','125879','9632587410', 6000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Suraj Pandit', 'surajp@gmail.com','889678','8012356478', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Sourav Das', 'souravd@gmail.com','775201','7410236598', 9000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Aditya Mondal', 'adityam@gmail.com','366920','7410325698', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Akash Basu', 'akashb@gmail.com','784503','7845120369', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Anisha Mukherjee', 'anisham@gmail.com','120778','6985741230', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Basudev Dutta', 'basud@gmail.com','452275','7458103296', 3000)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Rithik Sen', 'rithiks@gmail.com','658210','9396854103', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Rohit Nag', 'rhtn@gmail.com','545041','7456301859', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Animesh Sharma', 'anshrma@gmail.com','265056','8563012789', 7000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Sounak Laha', 'sounakl@gmail.com','125803','8510236947', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Laxmi Reddy', 'laxr@gmail.com','175566','7856930140', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Arpita Majhi', 'arptmjh@gmail.com','732236','6123789405', 3000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Anurag Basu', 'anuragb@gmail.com','126692','8569107778', 1500)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}