package com.example.produtos.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.produtos.R;
import com.example.produtos.model.Produto;
import com.example.produtos.view.adapter.ProdutoAdapter;
import com.example.produtos.view.interfaces.ProdutoListener;
import com.example.produtos.viewmodel.ProdutoViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProdutoListener {
    private TextInputLayout nome, quantidade;
    private FloatingActionButton fabAdd, fabDelete;
    private RecyclerView recyclerView;
    private ProdutoAdapter adapter;
    private ProdutoViewModel viewModel;
    private List<Produto> listaProdutos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProdutoAdapter(listaProdutos, this);
        viewModel = ViewModelProviders.of(this).get(ProdutoViewModel.class);

        viewModel.getTodosProdutos(this);

        viewModel.liveDataProduto.observe(this, produtos -> {
            adapter.atualizaListaProduto(produtos);
        });
    }

    public void initViews(){
        nome = findViewById(R.id.inputNome);
        quantidade = findViewById(R.id.inputQuantidade);
        fabAdd = findViewById(R.id.fabAdd);
        fabDelete = findViewById(R.id.fabRemove);
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void clickProduto(Produto produto) {

    }
}