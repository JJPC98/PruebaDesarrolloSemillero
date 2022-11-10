package veterinaria.data.data.dto;

public class Mascota {
    private int idmascota;
    private String nombre;
    private String especie;
    private String raza;
    private String fechanacimiento;
    private int  id_propietario;
    private String fecharegistro;

    public Mascota() {
        this.idmascota = idmascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.fechanacimiento = fechanacimiento;
        this.id_propietario = id_propietario;
        this.fecharegistro = fecharegistro;
    }

    public int getIdmascota() {
        return idmascota;
    }

    public void setIdmascota(int idmascota) {
        this.idmascota = idmascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public int getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(int id_dueño) {
        this.id_propietario = id_dueño;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
}
