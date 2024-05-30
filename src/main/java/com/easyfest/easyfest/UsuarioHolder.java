package com.easyfest.easyfest;

/**
 * La clase UsuarioHolder implementa el patrón Singleton para mantener una instancia única de un usuario.
 */
public class UsuarioHolder {

    /**
     * El usuario mantenido por el UsuarioHolder.
     */
    public Usuario usuario;

    /**
     * La instancia única de UsuarioHolder.
     */
    public final static UsuarioHolder INSTANCE = new UsuarioHolder();

    /**
     * Constructor privado para prevenir la instanciación externa.
     */
    private UsuarioHolder() {}

    /**
     * Obtiene la instancia única de UsuarioHolder.
     *
     * @return La instancia única de UsuarioHolder.
     */
    public static UsuarioHolder getInstance() {
        return INSTANCE;
    }

    /**
     * Establece el usuario mantenido por el UsuarioHolder.
     *
     * @param usuario El usuario a establecer.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el usuario mantenido por el UsuarioHolder.
     *
     * @return El usuario mantenido.
     */
    public Usuario getUsuario() {
        return usuario;
    }
}
