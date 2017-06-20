package ir.toptechnica.popupmenues.storage;

import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class DbSchema {

    public static final String DATABASE_NAME = "DB_Syndromes";
    public static final int DATABASE_VERSION = 1;
    public static final String PATH = "";
    public static final String SORT_ASC = " ASC";
    public static final String SORT_DESC = " DESC";
    public static final String TBL_TEMP = "tblTemp";


    public static class Syndrome_schema implements BaseColumns {

        public static final String TABLE_NAME = "Syndrome_tbl";
        public static final String COLUMN_ID = "Syndrome_Id";
        public static final String COLUMN_NAME = "Syndrome_Name";
        public static final String COLUMN_Incidence = "Syndrome_Incidence";
        public static final String COLUMN_Inheritance = "Syndrome_Inheritance";
        public static final String COLUMN_DDX = "Syndrome_DDX";
        public static final String COLUMN_Description = "Syndrome_Description";
        public static final String COLUMN_Images = "Syndrome_Images";
        public static final String COLUMN_Consulting = "Syndrome_Consulting";

        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }


}
