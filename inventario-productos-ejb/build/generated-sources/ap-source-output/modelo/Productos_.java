package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Unidades;
import modelo.Venta;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-16T00:56:05")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, String> descripcion;
    public static volatile SingularAttribute<Productos, Integer> existencia;
    public static volatile SingularAttribute<Productos, Unidades> unidad;
    public static volatile SingularAttribute<Productos, Double> precio;
    public static volatile SingularAttribute<Productos, Integer> idproductos;
    public static volatile CollectionAttribute<Productos, Venta> ventaCollection;
    public static volatile SingularAttribute<Productos, Date> fechaElab;

}