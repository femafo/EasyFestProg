package com.easyfest.easyfest;
/**
 * Interfaz que define un método para manejar el clic en un elemento de la lista de compras.
 *
 * @author femafo
 */
public interface MiListaC {
    /**
     * Método que se llama cuando se hace clic en un elemento de la lista de compras.
     *
     * @param productos el producto seleccionado
     */
    public void onClickLista(Productos productos);


}
