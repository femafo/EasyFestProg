package com.easyfest.easyfest;

public class UsuarioHolder {

    public Usuario usuario;
    public final static UsuarioHolder INSTANCE = new UsuarioHolder();

    public  UsuarioHolder() {}

    public static UsuarioHolder getInstance() {
        return INSTANCE;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}