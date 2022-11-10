package veterinaria.data.data.dao;

import veterinaria.data.data.dto.Mascota;
import veterinaria.data.data.exceptions.ExceptionDao;

import java.util.List;

public interface MascotaDaoInterface {
    public void insert(Mascota m ) throws ExceptionDao;
    public void update(Mascota m) throws ExceptionDao;
    public void delete(Mascota m) throws ExceptionDao;
    public Mascota getById(int idmascota) throws ExceptionDao;
    public List<Mascota> lista() throws ExceptionDao;
}
