package com.giutaca.loginmvp.vista;

import androidx.appcompat.app.AppCompatActivity;

import com.giutaca.loginmvp.interfaces.InterfaceLogin;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.giutaca.loginmvp.R;
import com.giutaca.loginmvp.modelos.Usuario;
import com.giutaca.loginmvp.presentador.PresentadorLogin;

public class MainActivity extends AppCompatActivity implements InterfaceLogin.Vista {

    TextView tv_usuario, tv_clave, tv_error;
    EditText et_usuario, et_clave;
    Button btn_loguearme;
    InterfaceLogin.Presentador presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         inicializarComponentes();

         btn_loguearme.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String usuario = et_usuario.getText().toString();
                 String clave = et_clave.getText().toString();
                 datosPresenter(usuario,clave);

             }
         });

    }

    private void inicializarComponentes() {
        tv_usuario = findViewById(R.id.textView2);
        tv_clave = findViewById(R.id.textView3);
        tv_error = findViewById(R.id.textView);
        et_usuario = findViewById(R.id.editTextTextPersonName);
        et_clave = findViewById(R.id.editTextTextPassword);
        btn_loguearme = findViewById(R.id.button);
        presenter = new PresentadorLogin(this);
    }


    @Override
    public void datosPresenter(String usuario, String clave) {
        presenter.datosModelo(usuario,clave);
    }

    @Override
    public void datosLogin(Usuario user) {
        //Hacer INTENT ETC, ETC.
        mostarErrorVista("Datos Correctos");
    }


    @Override
    public void mostarErrorVista(String error) {
        tv_error.setText(""+error);
    }
}