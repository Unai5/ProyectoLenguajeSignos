package org.cuatrovientos.diccionariolenguajesignos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.cuatrovientos.diccionariolenguajesignos.R;
import org.cuatrovientos.diccionariolenguajesignos.model.Categoria;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;

    public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.RecyclerDataHolder> {
        private List<Categoria> listaCategorias;
        private OnItemClickListener listener;

        public RecyclerDataAdapter(RealmResults<Categoria> list, OnItemClickListener listener){
            this.listaCategorias = list;
            this.listener = listener;
        }


        @NonNull
        @Override
        public RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categorias_list,null,false);
            return new RecyclerDataHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerDataHolder holder, int position) {
            holder.assignData(listaCategorias.get(position),listener);
        }

        @Override
        public int getItemCount() {
            return listaCategorias.size();
        }


        public class RecyclerDataHolder extends RecyclerView.ViewHolder {
            TextView  tv;
            public RecyclerDataHolder(@NonNull View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.tvCategoria);
            }

            public void assignData(Categoria categoria, OnItemClickListener listener) {

                tv.setText(categoria.getNombre());
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onItemClick(categoria, getAdapterPosition());
                    }
                });
            }
        }

        public interface OnItemClickListener{
            void onItemClick(Categoria categoria,int position);
        }
    }


