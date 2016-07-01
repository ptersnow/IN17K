package br.edu.ifms.pedro.trabalho.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import br.edu.ifms.pedro.trabalho.model.Troco;
import br.edu.ifms.pedro.trabalho.model.Usuario;
import br.edu.ifms.pedro.trabalho.util.SqliteHelper;

import java.util.ArrayList;
import java.util.List;

public class TrocoDAO {

    private SQLiteDatabase sqliteDatabase;
    private SqliteHelper sqliteHelper;

    public TrocoDAO(Context context) {
        sqliteHelper = new SqliteHelper(context);
    }

    public void open() throws SQLException {
        sqliteDatabase = sqliteHelper.getWritableDatabase();
    }

    public void close() {
        sqliteDatabase.close();
    }

    public Long createTroco(Troco troco) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m005", troco.getM005());
        contentValues.put("m010", troco.getM010());
        contentValues.put("m025", troco.getM025());
        contentValues.put("m050", troco.getM050());
        contentValues.put("m100", troco.getM100());
        contentValues.put("n200", troco.getN200());
        contentValues.put("n500", troco.getN500());
        contentValues.put("n1000", troco.getN1000());

        return sqliteDatabase.insert(SqliteHelper.TABLE_TROCO, null, contentValues);
    }

    public void deleteTroco(Troco troco) {
        Long id = troco.getId();

        sqliteDatabase.delete(SqliteHelper.TABLE_TROCO, "_id = " + id, null);
    }

    public List<Troco> getTrocoList() {
        List<Troco> trocoList = new ArrayList<>();

        String[] colunas = {"_id", "m005", "m010", "m025", "m050", "m100", "n200", "n500", "n1000"};

        Cursor cursor = sqliteDatabase.query(SqliteHelper.TABLE_TROCO, colunas, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            Troco troco = new Troco();

            troco.setId(cursor.getLong(0));
            troco.setM005(cursor.getInt(1));
            troco.setM010(cursor.getInt(2));
            troco.setM025(cursor.getInt(3));
            troco.setM050(cursor.getInt(4));
            troco.setM100(cursor.getInt(5));
            troco.setN200(cursor.getInt(6));
            troco.setN500(cursor.getInt(7));
            troco.setN1000(cursor.getInt(8));

            trocoList.add(troco);
            cursor.moveToNext();
        }

        cursor.close();
        return trocoList;
    }
}
