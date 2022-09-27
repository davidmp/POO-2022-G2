
package pe.edu.upeu.modelo;

public class MarcaTO {
        
    public String idMarca="M001";
    public String nombre;
    
    public MarcaTO(){ }

    public MarcaTO(String idMarca, String nombre) {
        this.idMarca = idMarca;
        this.nombre = nombre;
    }

    public String getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(String idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}