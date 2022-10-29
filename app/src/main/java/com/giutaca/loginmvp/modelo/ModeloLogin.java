package com.giutaca.loginmvp.modelo;

import static com.giutaca.loginmvp.constantes.Constantes.pass;
import static com.giutaca.loginmvp.constantes.Constantes.user;

import com.giutaca.loginmvp.constantes.Constantes;
import com.giutaca.loginmvp.interfaces.InterfaceLogin;
import com.giutaca.loginmvp.modelos.Usuario;

public class ModeloLogin implements InterfaceLogin.Modelo {

    InterfaceLogin.Presentador presenter;

    public ModeloLogin(InterfaceLogin.Presentador presenter) {
        this.presenter = presenter;
    }

    @Override
    public void datosPresentador(String usuario, String clave) {
            if(usuario.equals(user) && clave.equals(pass)){
                Usuario user = empaquetarConsulta();
                datosLogin(user);
                return;
            }
            presenter.mostarErrorPresnetador("Datos No Encontrados");
    }

    @Override
    public void datosLogin(Usuario user) {
        presenter.datosLogin(user);
    }

    private Usuario empaquetarConsulta() {
        Usuario user = new Usuario();
        user.setNombre("Giuseppe");
        user.setUsuario(Constantes.user);
        user.setClave(pass);
        return user;
    }


}
