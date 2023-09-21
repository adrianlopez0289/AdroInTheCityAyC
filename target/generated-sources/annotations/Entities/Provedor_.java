package Entities;

import Entities.Direcionprovedor;
import Entities.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-20T19:34:32")
@StaticMetamodel(Provedor.class)
public class Provedor_ { 

    public static volatile SingularAttribute<Provedor, Integer> idprov;
    public static volatile ListAttribute<Provedor, Direcionprovedor> direcionprovedorList;
    public static volatile SingularAttribute<Provedor, String> compañiaprov;
    public static volatile SingularAttribute<Provedor, Producto> nProduProve;

}