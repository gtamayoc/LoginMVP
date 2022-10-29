package com.giutaca.loginmvp.interfaces;

import com.giutaca.loginmvp.modelos.Usuario;

public interface InterfaceLogin {

    interface Modelo
    {
        void datosPresentador(String usuario, String clave);
        void datosLogin(Usuario user);
    }

    interface Vista
    {
        void datosPresenter(String usuario, String clave);
        void datosLogin(Usuario user);
        void mostarErrorVista(String error);
    }

    interface Presentador
    {
        void datosModelo(String usuario, String clave);
        void datosLogin(Usuario user);
        void mostarErrorPresnetador(String error);
    }

}
