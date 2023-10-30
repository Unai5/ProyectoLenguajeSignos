package org.cuatrovientos.diccionariolenguajesignos.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.cuatrovientos.diccionariolenguajesignos.R;
import org.cuatrovientos.diccionariolenguajesignos.R;

import java.util.ArrayList;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.RecyclerDataHolder> {

    ArrayList<Categoria> listaCategorias;

    public RecyclerDataAdapter(ArrayList<Categoria> listaCategorias) {
        this.listaNombresCategorias = listaNombresCategorias;
    }

    @NonNull
    @Override
    public RecyclerDataAdapter.RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDataAdapter.RecyclerDataHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RecyclerDataHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView tv;

        public RecyclerDataHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.imageView);
            tv = itemView.findViewById(R.id.textView);
        }

        public void assignData(Categoria categoria, final AdapterView.OnItemClickListener onItemClickListener) {
            //TODO: Importar clase categoría, y actualizar el nombre de los metodos setIdImagen y getTexto
            iv.setImageResource(categoria.getIdImagen());
            tv.setText(categoria.getTexto());

            /*
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(elementoLista,getAdapterPosition());
                }
            });
            */

        }

    }
}
