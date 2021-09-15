package com.example.laboratorio1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.laboratorio1.model.Categoria;

public class CategoriaRecycler extends AppCompatActivity{


    protected RecyclerView mRecyclerView;
    protected CategoriaAdapterRecycler mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    private Categoria cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_recycler);

        mRecyclerView = findViewById(R.id.categoriaRecycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CategoriaAdapterRecycler(Categoria.ejemplos());

        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Seleccionó: "+Categoria.ejemplos().get(mRecyclerView.getChildAdapterPosition(view)).getTitulo(),
                        Toast.LENGTH_SHORT).show();
                seleccionar(Categoria.ejemplos().get(mRecyclerView.getChildAdapterPosition(view)).getTitulo());
            }
        });

        mRecyclerView.setAdapter(mAdapter);


    }

    //este metodo lo que hace es volver a la pantalla principal cuando selecciona una categoria

    private void seleccionar(String categoria){

        Intent returnIntent = new Intent();
        //es para pasar la categoria a la otra pantalla
        returnIntent.putExtra("dato_categoria",categoria);
        setResult(CategoriaRecycler.RESULT_OK,returnIntent);
        finish();

    }

}