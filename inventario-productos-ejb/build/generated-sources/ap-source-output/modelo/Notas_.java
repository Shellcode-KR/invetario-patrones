package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Venta;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-05-18T11:32:13")
@StaticMetamodel(Notas.class)
public class Notas_ { 

    public static volatile SingularAttribute<Notas, Integer> numeroArticulosDiferentes;
    public static volatile ListAttribute<Notas, Venta> ventaList;
    public static volatile SingularAttribute<Notas, Integer> idnota;
    public static volatile SingularAttribute<Notas, Date> fechaNota;
    public static volatile SingularAttribute<Notas, Integer> importe;

}