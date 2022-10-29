package com.giutaca.loginmvp.presentador;

import com.giutaca.loginmvp.interfaces.InterfaceLogin;
import com.giutaca.loginmvp.modelo.ModeloLogin;
import com.giutaca.loginmvp.modelos.Usuario;

public class PresentadorLogin implements InterfaceLogin.Presentador {

    InterfaceLogin.Modelo modelo;
    InterfaceLogin.Vista vista;

    public PresentadorLogin(InterfaceLogin.Vista vista) {
        this.modelo = new ModeloLogin(this);
        this.vista = vista;
    }

    @Override
    public void datosModelo(String usuario, String clave) {
        if(usuario.isEmpty() || clave.isEmpty()){
            mostarErrorPresnetador("Campos Vacios");
            return;
        }
        modelo.datosPresentador(usuario,clave);
    }

    @Override
    public void datosLogin(Usuario user) {
        vista.datosLogin(user);
    }

    @Override
    public void mostarErrorPresnetador(String error) {
        vista.mostarErrorVista(error);
    }
}
