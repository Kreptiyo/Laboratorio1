package com.example.laboratorio1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.laboratorio1.model.Categoria;

public class CategoriaRecycler extends AppCompatActivity {


    protected RecyclerView mRecyclerView;
    protected CategoriaAdapterRecycler mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_recycler);

        mRecyclerView = findViewById(R.id.categoriaRecycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CategoriaAdapterRecycler(Categoria.ejemplos());
        mRecyclerView.setAdapter(mAdapter);

    }

}
