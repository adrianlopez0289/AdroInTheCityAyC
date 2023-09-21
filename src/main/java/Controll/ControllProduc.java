/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Controll;

import Entities.Producto;
import Model.ProductoFacadeLocal;
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
@Named(value = "controllProduc")
@SessionScoped
public class ControllProduc implements Serializable {
Producto produc = new Producto();
@EJB
ProductoFacadeLocal pflc ;
    public ControllProduc() {
    }

    public Producto getProduc() {
        return produc;
    }

    public void setProduc(Producto produc) {
        this.produc = produc;
    }

    public ProductoFacadeLocal getPflc() {
        return pflc;
    }

    public void setPflc(ProductoFacadeLocal pflc) {
        this.pflc = pflc;
    }
    
    public List<Producto> listar(){
        try{
            return this.pflc.findAll();
        }catch(Exception e){
            return null;
        }
    }
    
    public void insertar(){
        try{
            this.pflc.create(produc);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"El Producto se agrego correctamente","MSG_INFO"));
             produc = new Producto();
        }catch(Exception e){
        }
    }
    
    public void eliminar(Producto produc){
         try{
            this.pflc.remove(produc);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"El Producto se elimino correctamente","MSG_INFO"));
        }catch(Exception e){
        }
    }
    
    public void eviardatos(Producto produc){
        this.produc = produc;
     try {
        FacesContext.getCurrentInstance().getExternalContext().redirect("inventario-A.xhtml");
     } catch (IOException ex) {
        Logger.getLogger(ControllProduc.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    
    public void actualizar(){
     try {
        this.pflc.edit(produc);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"El Producto se Actualizo correctamente","MSG_INFO"));
         FacesContext.getCurrentInstance().getExternalContext().redirect("inventario.xhtml");
         produc = new Producto();
     } catch (IOException ex) {
          Logger.getLogger(ControllProduc.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
}
