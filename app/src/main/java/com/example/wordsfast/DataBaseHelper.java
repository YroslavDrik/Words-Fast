    package com.example.wordsfast;

    import android.annotation.SuppressLint;
    import android.content.ContentValues;
    import android.content.Context;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;

    import androidx.annotation.Nullable;

    public class DataBaseHelper extends SQLiteOpenHelper {

        private Context context;

        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "WordsFastDATABASE.db";
        private static final String TABLE_NAME = "WORDS";
        private static final String COLUMN_ID = "_id";
        private static final String COLUMN_WORD_ENG = "WORD_ENG";
        private static final String COLUMN_WORD_UK = "WORD_UK";
        private static final String COLUMN_WORD_TRANSCRIPTION = "WORD_TRANSCRIPTION";


        public DataBaseHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_WORD_ENG + " TEXT, " +
                    COLUMN_WORD_TRANSCRIPTION + " TEXT, " +
                    COLUMN_WORD_UK + " TEXT);";
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(sqLiteDatabase);
        }


        @SuppressLint("Range")
        public String getWordsDataBase(int id) {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            String selection = "_id = ?";
            String[] selectionArgs = new String[] {String.valueOf(id)};
            Cursor cursor = sqLiteDatabase.query(TABLE_NAME, null,  selection, selectionArgs, null, null, null);
            String result = null;

            if (cursor.moveToFirst()) {
                result = cursor.getString(cursor.getColumnIndex(COLUMN_WORD_ENG));
            }

            cursor.close();
            return result;
        }
        public void setDataBase(String[] WordsArrayENG , String[] WordsArrayTRANSCRIPTION , String[] WordsArrayUK){
            for(int i = 0 ; i<WordsArrayENG.length ;i++){
                SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
                ContentValues cv = new ContentValues();
                cv.put(COLUMN_WORD_ENG , WordsArrayENG[i]);
                cv.put(COLUMN_WORD_TRANSCRIPTION , WordsArrayTRANSCRIPTION[i]);
                cv.put(COLUMN_WORD_UK , WordsArrayUK[i]);
                sqLiteDatabase.insert(TABLE_NAME , null , cv);
            }
        }
    }
