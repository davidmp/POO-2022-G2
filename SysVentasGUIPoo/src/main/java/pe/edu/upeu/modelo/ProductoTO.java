
package pe.edu.upeu.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductoTO {    
    public String idProducto, nombre, idCategoria, idMarca;
    public double pu, utilidad, stock;

}