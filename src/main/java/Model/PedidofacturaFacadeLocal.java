/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import Entities.Pedidofactura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface PedidofacturaFacadeLocal {

    void create(Pedidofactura pedidofactura);

    void edit(Pedidofactura pedidofactura);

    void remove(Pedidofactura pedidofactura);

    Pedidofactura find(Object id);

    List<Pedidofactura> findAll();

    List<Pedidofactura> findRange(int[] range);

    int count();
    
}
