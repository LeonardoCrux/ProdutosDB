package com.example.produtos.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.produtos.model.Produto;
import com.example.produtos.repository.ProdutoRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProdutoViewModel extends AndroidViewModel {
    private ProdutoRepository repository = new ProdutoRepository();

    private MutableLiveData<List<Produto>> mutableProduto = new MutableLiveData<>();
    public LiveData<List<Produto>> liveDataProduto = mutableProduto;

    private CompositeDisposable disposable = new CompositeDisposable();


    public ProdutoViewModel(@NonNull Application application) {
        super(application);

           }

    public void getTodosProdutos(Context contexto){
        disposable.add(repository.getTodosProdutos(contexto)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(produto -> {
                            mutableProduto.setValue(produto);
                        },
                        throwable -> {
                            Log.i("Erro", throwable.getMessage());
                 })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
