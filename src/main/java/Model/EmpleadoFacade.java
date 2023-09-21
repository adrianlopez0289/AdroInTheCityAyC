/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entities.Empleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author HP
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> implements EmpleadoFacadeLocal {

    @PersistenceContext(unitName = "FRUVERLACAMI_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }
    
   @Override
    public Empleado IniciarSesion(Empleado empleado) {
        try{
            Query query = em.createQuery("Select e from Empleado e where e.iDEmp = :identidad and e.contraEmp = :password");
            query.setParameter("identidad", empleado.getIDEmp());
            query.setParameter("password", empleado.getContraEmp());
           List <Empleado> lista = query.getResultList();
            if(!lista.isEmpty()){
                empleado = lista.get(0);
            }else{
                empleado = null;
            }
        }catch(Exception e){
            
        }
        return empleado;
    }
}
