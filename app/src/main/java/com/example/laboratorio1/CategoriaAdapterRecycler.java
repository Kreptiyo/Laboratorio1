package com.example.laboratorio1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;

import com.example.laboratorio1.model.Categoria;

import java.util.List;

public class CategoriaAdapterRecycler extends RecyclerView.Adapter<CategoriaAdapterRecycler.ViewHolder>
        implements View.OnClickListener{

    private static final String TAG = "CategoriaAdapterRecycler";
    private List<Categoria> mDataSet;
    private View.OnClickListener listener;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo;
        View v;

        public ViewHolder(View fila) {
            super(fila);
            v = fila;
            tvTitulo = fila.findViewById(R.id.rowTitulo);
        }

        public View contenedor(){
            return v;
        }

        public TextView getTvTitulo() {
            return tvTitulo;
        }

    }


    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public CategoriaAdapterRecycler(List<Categoria> dataSet) {
        mDataSet = dataSet;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fila_cat, viewGroup, false);

        v.setOnClickListener(this);

        return new ViewHolder(v);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Categoria unaCategoria = mDataSet.get(position);
        if(position%2==0){
            viewHolder.contenedor().setBackgroundColor(Color.parseColor("#FFC0F3ED"));
        }

        viewHolder.tvTitulo.setText(unaCategoria.getTitulo());

    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void setOnClickListener(View.OnClickListener l){
        this.listener=l;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);

            //cuando seleccione una categoria, que se ponga el fondo en rojo
            view.setBackgroundColor(Color.RED);
        }
    }

}