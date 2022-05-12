package com.example.tp1_lab3_loginpreferencias.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tp1_lab3_loginpreferencias.R;
import com.example.tp1_lab3_loginpreferencias.model.Usuario;


public class RegistroActivity extends AppCompatActivity {

    private Context context;
    private TextView etNombre;
    private TextView etApellido, etDni,etEmail,etPass;
    private Button btGuardar;
    private ViewModelRegistro vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelRegistro.class);

        vm.getUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                etNombre.setText(usuario.getNombre()+"");
                etApellido.setText(usuario.getApellido()+"");
                etDni.setText(usuario.getDni()+"");
                etEmail.setText(usuario.getMail()+"");
                etPass.setText(usuario.getPassword()+"");
            }
        });
        vm.leerDatos();
        inicializarVista();
    }

    public void inicializarVista(){
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etDni = findViewById(R.id.etDni);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btGuardar = findViewById(R.id.button);


        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario u= new Usuario(etDni.getText().toString(),etApellido.getText().toString(),etNombre.getText().toString(),etEmail.getText().toString(),etPass.getText().toString());
                vm.guardarDatos(u);
            }
        });
    }



}