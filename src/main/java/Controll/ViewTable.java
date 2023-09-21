/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controll;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author HP
 */
@Named(value = "viewTable")
@SessionScoped
public class ViewTable implements Serializable {
  private boolean tablaVisible = false;
  
    public ViewTable() {
    }
    
    public boolean isTablaVisible() {
        return tablaVisible;
    }

    public void setTablaVisible(boolean tablaVisible) {
        this.tablaVisible = tablaVisible;
    }

    public void mostrarOcultarTabla() {
        tablaVisible = !tablaVisible;
    }
}
