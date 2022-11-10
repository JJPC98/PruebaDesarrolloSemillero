package veterinaria.data.data.manager;

import veterinaria.data.data.dto.Mascota;
import veterinaria.data.data.exceptions.ExceptionManager;

import java.util.List;

public interface ImgrMascota {
    public void Save(Mascota mascota) throws ExceptionManager;;
    public void Delete(Mascota mascota) throws ExceptionManager;;
    public void Update(Mascota mascota) throws ExceptionManager;;
    public List<Mascota> lista() throws ExceptionManager;
}
