/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import Entities.Factura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface FacturaFacadeLocal {

    void create(Factura factura);

    void edit(Factura factura);

    void remove(Factura factura);

    Factura find(Object id);

    List<Factura> findAll();

    List<Factura> findRange(int[] range);

    int count();
    
}
