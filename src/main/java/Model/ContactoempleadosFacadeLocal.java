/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import Entities.Contactoempleados;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface ContactoempleadosFacadeLocal {

    void create(Contactoempleados contactoempleados);

    void edit(Contactoempleados contactoempleados);

    void remove(Contactoempleados contactoempleados);

    Contactoempleados find(Object id);

    List<Contactoempleados> findAll();

    List<Contactoempleados> findRange(int[] range);

    int count();
    
}
