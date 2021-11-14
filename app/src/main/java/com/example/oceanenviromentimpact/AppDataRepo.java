package com.example.oceanenviromentimpact;

import android.provider.BaseColumns;

public class AppDataRepo {
    private AppDataRepo() {}

    public static class WasteCountEntry implements BaseColumns {
        public static final String TABLE_NAME = "WASTECOUNT";
        public static final String COLUMN_NAME_WASTEAMOUNT = "WasteAmount";
        public static final String COLUMN_NAME_ID = "Id";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + WasteCountEntry.TABLE_NAME + " (" +
                    WasteCountEntry._ID + " INTEGER PRIMARY KEY, " +
                    WasteCountEntry.COLUMN_NAME_WASTEAMOUNT + " INT, " +
                    WasteCountEntry.COLUMN_NAME_ID + " INT "+
                    ")";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + WasteCountEntry.TABLE_NAME;
}
