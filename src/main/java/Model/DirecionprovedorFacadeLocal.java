/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import Entities.Direcionprovedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface DirecionprovedorFacadeLocal {

    void create(Direcionprovedor direcionprovedor);

    void edit(Direcionprovedor direcionprovedor);

    void remove(Direcionprovedor direcionprovedor);

    Direcionprovedor find(Object id);

    List<Direcionprovedor> findAll();

    List<Direcionprovedor> findRange(int[] range);

    int count();
    
}
