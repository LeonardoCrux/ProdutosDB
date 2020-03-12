package com.example.produtos.repository;

import android.content.Context;

import com.example.produtos.model.Produto;
import com.example.produtos.repository.data.ProdutoDataBase;

import java.util.List;

import io.reactivex.Flowable;

public class ProdutoRepository {

    public Flowable<List<Produto>> getTodosProdutos(Context context){
        return ProdutoDataBase.getDatabase(context).produtoDAO().todosOsProdutosBd();
    }
}
