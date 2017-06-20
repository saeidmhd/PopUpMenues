package ir.toptechnica.popupmenues.storage;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import ir.toptechnica.popupmenues.data.Syndrome_Data;
import ir.toptechnica.popupmenues.data.Syndrome_Model;

public class DbAdapter {
    private Context mCtx;
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;
    public static String DB_PATH;

    private static class DatabaseHelper extends SQLiteOpenHelper {
        private Context mContext;
        private SQLiteDatabase Db;

        public DatabaseHelper(Context context) {
            super(context, DbSchema.DATABASE_NAME, null, DbSchema.DATABASE_VERSION);
            this.mContext = context;
            DB_PATH = Environment.getDataDirectory() + "/data/" + context.getPackageName() + "/databases/";
        }

        public void createDataBase() throws IOException {
            //If database not exists copy it from the assets
            this.getReadableDatabase();
            this.close();
            try {
                //Copy the database from assests
                copyDataBase();
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }

        //Copy the database from assets
        private void copyDataBase() throws IOException {
            InputStream mInput = mContext.getAssets().open(DbSchema.DATABASE_NAME);
            String outFileName = DB_PATH + DbSchema.DATABASE_NAME;
            OutputStream mOutput = new FileOutputStream(outFileName);
            byte[] mBuffer = new byte[1024];
            int mLength;
            while ((mLength = mInput.read(mBuffer)) > 0) {
                mOutput.write(mBuffer, 0, mLength);
            }
            mOutput.flush();
            mOutput.close();
            mInput.close();
        }

        public SQLiteDatabase openDataBase() throws SQLException {
            String mPath = DB_PATH + DbSchema.DATABASE_NAME;
            Db = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.OPEN_READWRITE);
            return Db;
        }

        public Boolean CheckDatabase() {
            Boolean res = false;
            File file = new File(DB_PATH + DbSchema.DATABASE_NAME);
            res = file.exists();
            return res;
        }

        @Override
        public synchronized void close() {
            if (Db != null)
                Db.close();
            super.close();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
        }

        /**
         * Called when the database needs to be upgraded. The implementation
         * should use this method to drop tables, add tables, or do anything else it
         * needs to upgrade to the new schema version.
         * <p>
         * <p>
         * The SQLite ALTER TABLE documentation can be found
         * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
         * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
         * you can use ALTER TABLE to rename the old table, then create the new table and then
         * populate the new table with the contents of the old table.
         * </p><p>
         * This method executes within a transaction.  If an exception is thrown, all changes
         * will automatically be rolled back.
         * </p>
         *
         * @param db         The database.
         * @param oldVersion The old database version.
         * @param newVersion The new database version.
         */
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

    }

    public DbAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    public DbAdapter open() {
        this.mDbHelper = new DatabaseHelper(mCtx);
        if (!mDbHelper.CheckDatabase()) {
            try {
                mDbHelper.createDataBase();
                this.mDb = mDbHelper.openDataBase();

            } catch (Exception e) {

            }
        } else
            this.mDb = mDbHelper.openDataBase();

        return this;
    }

    public void close() {
        mDbHelper.close();
    }



    //QUERIES GET_______________________________________________________________________

/*
    public Syndrome_Data GetCustomerGroup(long id) {
        Syndrome_Model mSyndrome_Model = null;
        Cursor cursor = null;
        try {
            cursor = mDb.query(DbSchema.Syndrome_schema.TABLE_NAME, null, null, null, null, null,null);
            cursor.moveToFirst();
            if (cursor != null && cursor.getCount() > 0) {
                mSyndrome_Model = new Syndrome_Model(mCtx);
                mSyndrome_Model.setId(cursor.getLong(cursor.getColumnIndex(DbSchema.Syndrome_schema.COLUMN_ID)));
                mSyndrome_Model.setMahakId(cursor.getString(cursor.getColumnIndex(DbSchema.Syndrome_schema.COLUMN_NAME)));
                mSyndrome_Model.setMasterId(cursor.getLong(cursor.getColumnIndex(DbSchema.Syndrome_schema.COLUMN_DDX)));
                mSyndrome_Model.setDatabaseId(cursor.getString(cursor.getColumnIndex(DbSchema.Syndrome_schema.COLUMN_Incidence)));
                mSyndrome_Model.setName(cursor.getString(cursor.getColumnIndex(DbSchema.Syndrome_schema.COLUMN_Inheritance)));
                mSyndrome_Model.setIcon(cursor.getString(cursor.getColumnIndex(DbSchema.Syndrome_schema.COLUMN_Consulting)));
                mSyndrome_Model.setColor(cursor.getInt(cursor.getColumnIndex(DbSchema.Syndrome_schema.COLUMN_Images)));
                mSyndrome_Model.setModifyDate(cursor.getLong(cursor.getColumnIndex(DbSchema.Syndrome_schema.COLUMN_Description)));

                cursor.close();
            }
        } catch (Exception e) {
            Log.e("Error Query GetCustomerGroup", e.getMessage());
        }
        return mSyndrome_Model;
    }*/



}
