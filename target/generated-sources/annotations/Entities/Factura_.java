package Entities;

import Entities.Pedidofactura;
import Entities.Venta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-20T19:34:32")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Date> fechaFactura;
    public static volatile SingularAttribute<Factura, Venta> nVentaFac;
    public static volatile ListAttribute<Factura, Pedidofactura> pedidofacturaList;
    public static volatile SingularAttribute<Factura, Integer> nFactura;

}