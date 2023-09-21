package Entities;

import Entities.Factura;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-20T19:34:32")
@StaticMetamodel(Pedidofactura.class)
public class Pedidofactura_ { 

    public static volatile SingularAttribute<Pedidofactura, Date> fechaPedidoFactu;
    public static volatile SingularAttribute<Pedidofactura, Factura> nFacturaPediFac;
    public static volatile SingularAttribute<Pedidofactura, Integer> nPedidoFactu;

}