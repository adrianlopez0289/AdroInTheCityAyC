/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entities.Pedidofactura;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class PedidofacturaFacade extends AbstractFacade<Pedidofactura> implements PedidofacturaFacadeLocal {

    @PersistenceContext(unitName = "FRUVERLACAMI_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidofacturaFacade() {
        super(Pedidofactura.class);
    }
    
}
