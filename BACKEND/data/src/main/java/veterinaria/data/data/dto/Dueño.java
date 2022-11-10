package veterinaria.data.data.dto;

public class Dueño {

    private int idpropietario;
    private String tipoid;
    private String nombre;
    private String ciudad;
    private String direccion;
    private String telefono;

    public Dueño() {
        this.idpropietario = idpropietario;
        this.tipoid = tipoid;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getIdpropietario() {
        return idpropietario;
    }

    public void setIdpropietario(int iddueño) {
        this.idpropietario = iddueño;
    }

    public String getTipoid() {
        return tipoid;
    }

    public void setTipoid(String tipoid) {
        this.tipoid = tipoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
