package Entities;

import Entities.Categoria;
import Entities.Provedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-20T19:34:32")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Integer> nProdu;
    public static volatile ListAttribute<Producto, Provedor> provedorList;
    public static volatile SingularAttribute<Producto, Integer> precioUniprodu;
    public static volatile SingularAttribute<Producto, String> nombreProdu;
    public static volatile SingularAttribute<Producto, Integer> cantpro;
    public static volatile ListAttribute<Producto, Categoria> categoriaList;

}