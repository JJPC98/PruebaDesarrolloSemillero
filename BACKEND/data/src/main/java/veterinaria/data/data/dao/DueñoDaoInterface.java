package veterinaria.data.data.dao;

import veterinaria.data.data.dto.Dueño;
import veterinaria.data.data.exceptions.ExceptionDao;

import java.util.List;

public interface DueñoDaoInterface {

    public void insert(Dueño d) throws ExceptionDao;
    public void update(Dueño d) throws ExceptionDao;
    public void delete(Dueño d) throws ExceptionDao;
    public Dueño getById(int idpropietario) throws ExceptionDao;
    public List<Dueño> lista() throws ExceptionDao;

}
