/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controll;

import Entities.Empleado;
import Model.EmpleadoFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author HP
 */
@Named(value = "controllEmpleado")
@SessionScoped
public class ControllEmpleado implements Serializable {
Empleado emp = new Empleado();
@EJB
EmpleadoFacadeLocal efl;


    public ControllEmpleado() {
    }

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }


    public EmpleadoFacadeLocal getEfl() {
        return efl;
    }

    public void setEfl(EmpleadoFacadeLocal efl) {
        this.efl = efl;
    }
    
    public void insertaremp(){
        try{
            this.efl.create(emp);
            emp = new Empleado();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"El Empleado se agrego correctamente","MSG_INFO"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "El Empleado no se agrego correctamente", "MSG_ERROR"));
        }
    
    }
    
    public List<Empleado> listar() {
        try {
            return this.efl.findAll();
        } catch (Exception e) {
            return null;
        }
    }
    
    public void eliminar(Empleado empleado) {
        try {
            this.efl.remove(empleado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El Empleado se elimino correctamente", "MSG_INFO"));
        } catch (Exception e) {
        }
    }
    
    public void eviardatos(Empleado emp){
        this.emp = emp;
     try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("recursoshumanos-A.xhtml");
     } catch (IOException ex) {
        Logger.getLogger(ControllEmpleado.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    
    public void actualizar(){
     try {
        this.efl.edit(emp);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"El Producto se Actualizo correctamente","MSG_INFO"));
         FacesContext.getCurrentInstance().getExternalContext().redirect("recursoshumanos.xhtml");
         emp = new Empleado();
     } catch (IOException ex) {
          Logger.getLogger(ControllEmpleado.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
}
