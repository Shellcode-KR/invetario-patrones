package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Notas;
import modelo.Productos;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-06T10:25:27")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Integer> idventa;
    public static volatile SingularAttribute<Venta, Notas> folioNota;
    public static volatile SingularAttribute<Venta, Integer> cantidad;
    public static volatile SingularAttribute<Venta, Productos> idProducto;
    public static volatile SingularAttribute<Venta, Double> importe;

}