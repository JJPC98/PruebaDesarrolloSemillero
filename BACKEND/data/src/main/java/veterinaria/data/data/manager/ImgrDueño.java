package veterinaria.data.data.manager;

import veterinaria.data.data.dto.Dueño;
import veterinaria.data.data.exceptions.ExceptionManager;

import java.util.List;

public interface ImgrDueño {
    public void Save(Dueño dueño) throws ExceptionManager;;
    public void Delete(Dueño dueño) throws ExceptionManager;;
    public void Update(Dueño dueño) throws ExceptionManager;;
    public List<Dueño> lista() throws ExceptionManager;
}
