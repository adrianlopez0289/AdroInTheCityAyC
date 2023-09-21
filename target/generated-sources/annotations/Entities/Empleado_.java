package Entities;

import Entities.Cliente;
import Entities.Contactoempleados;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-20T19:34:32")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> apellidoEmp;
    public static volatile ListAttribute<Empleado, Cliente> clienteList;
    public static volatile SingularAttribute<Empleado, String> cargoEmp;
    public static volatile ListAttribute<Empleado, Contactoempleados> contactoempleadosList;
    public static volatile SingularAttribute<Empleado, String> correoEmp;
    public static volatile SingularAttribute<Empleado, Integer> iDEmp;
    public static volatile SingularAttribute<Empleado, String> contraEmp;
    public static volatile SingularAttribute<Empleado, String> nombreEmp;

}