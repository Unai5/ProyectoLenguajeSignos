package org.cuatrovientos.diccionariolenguajesignos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.cuatrovientos.diccionariolenguajesignos.R;
import org.cuatrovientos.diccionariolenguajesignos.model.Palabra;

import java.util.List;

public class RecyclerPalabraAdapter extends RecyclerView.Adapter<RecyclerPalabraAdapter.RecyclerDataHolder>{
    private List<Palabra> listPalabras;

    private OnItemClickListener itemListener;
    private Context context;

    public void setFilteredList(List<Palabra> filteredList){
        this.listPalabras = filteredList;
        notifyDataSetChanged();
    }

    public RecyclerPalabraAdapter(Context context, List<Palabra> listDataPalabra, OnItemClickListener listener){
        this.context=context;
        this.listPalabras = listDataPalabra;
        this.itemListener=listener;

    }
    @NonNull
    @Override
    public RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_palabra , parent , false);
        return new RecyclerDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDataHolder holder, int position) {

        holder.asignData(listPalabras.get(position),itemListener );
    }

    @Override
    public int getItemCount() {
        return listPalabras.size();
    }

    public class RecyclerDataHolder extends RecyclerView.ViewHolder {
        TextView data;
        ImageView image;
        public RecyclerDataHolder(@NonNull View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.txtPalabra);
            image = itemView.findViewById(R.id.imgPalabra);
        }
        public void asignData(Palabra palabra, OnItemClickListener onItemClickListener ){
            data.setText(palabra.getPalabra());
            image.setImageResource(palabra.getImagen());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(palabra.getId());
                }
            });
        }

    }
    public interface  OnItemClickListener{
        void onItemClick(int id  );
    }
}