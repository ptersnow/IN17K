package br.edu.ifms.pedro.trabalho.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import br.edu.ifms.pedro.trabalho.model.Usuario;
import br.edu.ifms.pedro.trabalho.util.SqliteHelper;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private SQLiteDatabase sqliteDatabase;
    private SqliteHelper sqliteHelper;

    public UsuarioDAO(Context context) {
        sqliteHelper = new SqliteHelper(context);
    }

    public void open() throws SQLException {
        sqliteDatabase = sqliteHelper.getWritableDatabase();
    }

    public void close() {
        sqliteDatabase.close();
    }

    public Usuario createUsuario(Usuario usuario) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", usuario.getNome());
        contentValues.put("endereco", usuario.getEndereco());
        contentValues.put("telefone", usuario.getTelefone());
        contentValues.put("uf", usuario.getUf());
        contentValues.put("email", usuario.getEmail());

        Long id = sqliteDatabase.insert(SqliteHelper.TABLE_USUARIO, null, contentValues);
        usuario.setId(id);

        return usuario;
    }

    public void deleteUsuario(Usuario usuario) {
        Long id = usuario.getId();

        sqliteDatabase.delete(SqliteHelper.TABLE_USUARIO, "_id = " + id, null);
    }

    public List<Usuario> getUsuarioList() {
        List<Usuario> usuarioList = new ArrayList<>();

        String[] colunas = {"_id", "nome", "endereco", "telefone", "uf", "email"};

        Cursor cursor = sqliteDatabase.query(SqliteHelper.TABLE_USUARIO, colunas, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            Usuario usuario = new Usuario();

            usuario.setId(cursor.getLong(0));
            usuario.setNome(cursor.getString(1));
            usuario.setEndereco(cursor.getString(2));
            usuario.setTelefone(cursor.getString(3));
            usuario.setUf(cursor.getString(4));
            usuario.setEmail(cursor.getString(5));

            usuarioList.add(usuario);
            cursor.moveToNext();
        }

        cursor.close();
        return usuarioList;
    }


}
