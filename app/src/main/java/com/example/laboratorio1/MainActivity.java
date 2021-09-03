package com.example.laboratorio1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private Switch switchDescuento;
    private SeekBar seekBarDescuento;
    private CheckBox checkBoxRetiro;
    private TextView direccionRetiroTitulo;
    private EditText direccionRetiroInput;
    private CheckBox checkBoxTerminos;
    private Button btnPublicar;
    //Validar
    private EditText inputTitulo;
    private EditText inputPrecio;
    private EditText inputDireccionRetiro;
    private EditText inputEmail;
    private EditText inputDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchDescuento = findViewById(R.id.switch1);
        seekBarDescuento = findViewById(R.id.seekBar2);
        checkBoxRetiro = findViewById(R.id.checkBox);
        direccionRetiroTitulo = findViewById(R.id.textView8);
        direccionRetiroInput = findViewById(R.id.editTextTextPersonName3);
        checkBoxTerminos = findViewById(R.id.checkBox2);
        btnPublicar = findViewById(R.id.button);
        //Validar
        inputTitulo = findViewById(R.id.editTextTextPersonName);
        inputPrecio = findViewById(R.id.editTextNumber);
        inputDireccionRetiro = findViewById(R.id.editTextTextPersonName3);
        inputEmail = findViewById(R.id.editTextTextEmailAddress);
        inputDescripcion = findViewById(R.id.editTextTextPersonName2);


        switchDescuento.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    seekBarDescuento.setVisibility(View.VISIBLE);
                }
                else
                {
                    seekBarDescuento.setVisibility(View.GONE);
                }
            }
        });

        checkBoxRetiro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    direccionRetiroTitulo.setVisibility(View.VISIBLE);
                    direccionRetiroInput.setVisibility(View.VISIBLE);
                }
                else
                {
                    direccionRetiroTitulo.setVisibility(View.GONE);
                    direccionRetiroInput.setVisibility(View.GONE);
                }
            }
        });

        checkBoxTerminos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    btnPublicar.setEnabled(true);
                }
                else
                {
                    btnPublicar.setEnabled(false);
                }
            }
        });

        btnPublicar.setOnClickListener(new View.OnClickListener()
        {
            StringBuilder mensajeAMostrar = new StringBuilder();
            public void onClick(View v)
            {
                if(inputTitulo.getText().toString().isEmpty())
                {
                    mensajeAMostrar.append("\n"+"- Titulo. (Campo Obligatorio)"+"\n");
                }
                if(inputPrecio.getText().toString().isEmpty())
                {
                    mensajeAMostrar.append("\n"+"- Precio. (Campo Obligatorio)"+"\n");
                }
                if(checkBoxRetiro.isChecked())
                {
                    if(inputDireccionRetiro.getText().toString().isEmpty())
                    {
                        mensajeAMostrar.append("\n"+"- Direccion de retiro. (Campo Obligatorio)"+"\n");
                    }
                }
                if(switchDescuento.isChecked())
                {
                    if(seekBarDescuento.getProgress() == 0)
                    {
                        mensajeAMostrar.append("\n"+"- Por favor seleccione un porcentaje mayor a 0 o quite la opcion de ofrecer descuento de envio"+"\n");
                    }
                }
                if(!inputPrecio.getText().toString().isEmpty() && Integer.parseInt(inputPrecio.getText().toString()) <= 0)
                {
                    mensajeAMostrar.append("\n"+"- El precio del producto debe ser mayor a 0"+"\n");
                }
                if(!inputEmail.getText().toString().isEmpty())
                {
                    if(!validarEmail(inputEmail.getText().toString()))
                    {
                        mensajeAMostrar.append("\n"+"- Email invalido"+"\n");
                    }
                }
                if(!inputTitulo.getText().toString().isEmpty())
                {
                    if(!validarCamposTextoPlano(inputTitulo.getText().toString()))
                    {
                        mensajeAMostrar.append("\n"+"- El titulo contiene simbolos no permitidos"+"\n");
                    }
                }
                if(!inputDescripcion.getText().toString().isEmpty())
                {
                    if(!validarCamposTextoPlano(inputDescripcion.getText().toString()))
                    {
                        mensajeAMostrar.append("\n"+"- La descripcion contiene simbolos no permitidos"+"\n");
                    }
                }
                if(!inputDireccionRetiro.getText().toString().isEmpty())
                {
                    if(!validarCamposTextoPlano(inputDireccionRetiro.getText().toString()))
                    {
                        mensajeAMostrar.append("\n"+"- La direccion de retiro contiene simbolos no permitidos"+"\n");
                    }
                }
                if(mensajeAMostrar.length() != 0)
                {
                    Toast toastError = Toast.makeText(getApplicationContext(), mensajeAMostrar, Toast.LENGTH_SHORT);
                    toastError.show();
                    mensajeAMostrar.setLength(0);
                }
                else
                {
                    Toast toastExito = Toast.makeText(getApplicationContext(), "Publicación Registrada Exitosamente", Toast.LENGTH_SHORT);
                    toastExito.show();
                }
            }
        });

    }

    private boolean validarEmail(String email) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9!#$%&'*_+-]([\\.]?[a-zA-Z0-9!#$%&'*_+-])+@[a-zA-Z0-9]([^@&%$\\/()=?¿!.,:;]|\\d)+[a-zA-Z0-9][\\.][a-zA-Z]{2,4}([\\.][a-zA-Z]{2})?");
        return pattern.matcher(email).matches();
    }

    private boolean validarCamposTextoPlano(String campoTexto) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9,.\\s]+");
        return pattern.matcher(campoTexto).matches();
    }

}