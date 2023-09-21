/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controll;

import Entities.Empleado;
import Model.EmpleadoFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author HP
 */
@Named(value = "controllSession")
@SessionScoped
public class ControllSession implements Serializable {
  Empleado empleado = new Empleado();
    @EJB
    EmpleadoFacadeLocal eflc;

    public ControllSession() {
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public EmpleadoFacadeLocal getEflc() {
        return eflc;
    }

    public void setEflc(EmpleadoFacadeLocal eflc) {
        this.eflc = eflc;
    }
    public void validarEmpleado() {
        String redirec = "";

        try {
            this.empleado = eflc.IniciarSesion(empleado);
            if (this.empleado != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rol", empleado.getCargoEmp());
                 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", empleado.getNombreEmp());
                redirec = "pageinicial.xhtml";
                FacesContext.getCurrentInstance().getExternalContext().redirect(redirec);
            } else {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "IDENTIFICACION O CONTRASEÑA INCORRECTA", "MSG_ERROR"));
                // redirec ="login.xhtml";
                // FacesContext.getCurrentInstance().getExternalContext().redirect(redirec);

            }
        } catch (Exception e) {

        }
        empleado = new Empleado();
    }
}
