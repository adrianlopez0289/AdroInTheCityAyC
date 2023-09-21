/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controll;

import Entities.Venta;
import Model.VentaFacadeLocal;
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
@Named(value = "controllVenta")
@SessionScoped
public class ControllVenta implements Serializable {
Venta vent = new Venta();
@EJB
VentaFacadeLocal vflc;
    public ControllVenta() {
    }

    public Venta getVent() {
        return vent;
    }

    public void setVent(Venta vent) {
        this.vent = vent;
    }

    public VentaFacadeLocal getVflc() {
        return vflc;
    }

    public void setVflc(VentaFacadeLocal vflc) {
        this.vflc = vflc;
    }
    public List<Venta> listar(){
      try{
          return this.vflc.findAll();
      }catch(Exception e){
          return null;
      }
  }
  public void insertar(){
        try{
            this.vflc.create(vent);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"La venta se agrego correctamente","MSG_INFO"));
             vent = new Venta();
        }catch(Exception e){
        }
    }
  public void eliminar(Venta vent){
        try{
            this.vflc.remove(vent);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"La venta se elimino correctamente","MSG_INFO"));
        }catch(Exception e){
        }
    }
   public void enviardatos(Venta vent){
      this.vent = vent;
     try{
         FacesContext.getCurrentInstance().getExternalContext().redirect("ventas-A.xhtml");
     } catch (IOException ex){
         Logger.getLogger(ControllVenta.class.getName()).log(Level.SEVERE,null,ex);
     } 
  }
   public void actualizar(){
        try{
            this.vflc.edit(vent);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"La venta se actualizo correctamente","MSG_INFO"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("ventas.xhtml");
            vent = new Venta();
        }catch(IOException ex){
            Logger.getLogger(ControllVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
