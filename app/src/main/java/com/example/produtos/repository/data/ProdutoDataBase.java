package com.example.produtos.repository.data;

import android.content.Context;

import com.example.produtos.model.Produto;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Produto.class}, version = 1, exportSchema = false)
public abstract class ProdutoDataBase extends RoomDatabase {
    public abstract ProdutoDAO produtoDAO();

    private static volatile ProdutoDataBase INSTANCE;

    public static ProdutoDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProdutoDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ProdutoDataBase.class, "produtos_bd")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
