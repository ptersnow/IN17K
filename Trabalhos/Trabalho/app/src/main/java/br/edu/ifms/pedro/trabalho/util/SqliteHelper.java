package br.edu.ifms.pedro.trabalho.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteHelper extends SQLiteOpenHelper {

    public static final String TABLE_USUARIO = "usuario";

    public static final String TABLE_TROCO = "troco";

    private static final String DATABASE_NAME = "app_troco.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TB_USUARIO = "create table " + TABLE_USUARIO +
            "( _id integer primary key autoincrement," +
            "nome text not null," +
            "endereco text not null," +
            "telefone text not null," +
            "uf text not null," +
            "email text not null)";

    private static final String CREATE_TB_TROCO = "create table " + TABLE_TROCO +
            "( _id integer primary key autoincrement," +
            "m005 integer not null," +
            "m010 integer not null," +
            "m025 integer not null," +
            "m050 integer not null," +
            "m100 integer not null," +
            "n200 integer not null," +
            "n500 integer not null," +
            "n1000 integer not null)";

    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TB_USUARIO);
        db.execSQL(CREATE_TB_TROCO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TROCO);

        onCreate(db);
    }
}
