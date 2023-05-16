package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Notas;
import modelo.Productos;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-16T00:56:05")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Integer> idventa;
    public static volatile SingularAttribute<Venta, Notas> folioNota;
    public static volatile SingularAttribute<Venta, Integer> cantidad;
    public static volatile SingularAttribute<Venta, Productos> idProducto;

}