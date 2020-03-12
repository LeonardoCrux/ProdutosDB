package com.example.produtos.repository.data;

import com.example.produtos.model.Produto;

import java.util.List;
import java.util.Observable;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Flowable;

import static android.icu.text.MessagePattern.ArgType.SELECT;

public interface ProdutoDAO {

    @Insert
    void insereProduto();

    @Delete
    void deletaProduto();

    @Update
    void updateProduto(Produto produto);

    @Query("SELECT * FROM produtos WHERE nome=:nome")
    Produto geProdutoPorNomeBd(String nome);

    @Query("SELECT * FROM produtos")
    Flowable<List<Produto>> todosOsProdutosBd();
}
