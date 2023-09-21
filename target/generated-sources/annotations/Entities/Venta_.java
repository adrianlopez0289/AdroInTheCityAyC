package Entities;

import Entities.Cliente;
import Entities.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-20T19:34:32")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile ListAttribute<Venta, Cliente> clienteList;
    public static volatile SingularAttribute<Venta, Integer> canProduct;
    public static volatile SingularAttribute<Venta, Integer> valorVenta;
    public static volatile ListAttribute<Venta, Factura> facturaList;
    public static volatile SingularAttribute<Venta, String> nomProducto;
    public static volatile SingularAttribute<Venta, Integer> nVenta;

}