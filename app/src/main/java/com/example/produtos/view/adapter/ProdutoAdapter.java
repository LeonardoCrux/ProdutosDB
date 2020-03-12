package com.example.produtos.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.produtos.R;
import com.example.produtos.model.Produto;
import com.example.produtos.view.interfaces.ProdutoListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHoler> {

    private List<Produto> listaProdutos;
    private ProdutoListener listener;

    public ProdutoAdapter(List<Produto> listaProdutos, ProdutoListener listener) {
        this.listaProdutos = listaProdutos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quantidade, parent, false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        final Produto produto = listaProdutos.get(position);
        holder.onBind(produto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.clickProduto(produto);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    public void atualizaListaProduto(List<Produto> novaListaProduto){
        this.listaProdutos.clear();
        this.listaProdutos = novaListaProduto;
        notifyDataSetChanged();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        private TextView nome;
        private TextView quantidade;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textNomeEstoque);
            quantidade = itemView.findViewById(R.id.textQuantidadeEstoque);
        }

        public void onBind(Produto produto) {
            nome.setText(produto.getNome());
            quantidade.setText(produto.getQuantidade());
        }
    }
}
