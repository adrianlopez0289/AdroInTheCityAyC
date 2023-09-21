/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import Entities.Provedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface ProvedorFacadeLocal {

    void create(Provedor provedor);

    void edit(Provedor provedor);

    void remove(Provedor provedor);

    Provedor find(Object id);

    List<Provedor> findAll();

    List<Provedor> findRange(int[] range);

    int count();
    
}
