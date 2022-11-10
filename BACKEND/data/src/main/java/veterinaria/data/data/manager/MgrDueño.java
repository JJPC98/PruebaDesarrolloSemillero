package veterinaria.data.data.manager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import veterinaria.data.data.dao.DueñoDaoInterface;
import veterinaria.data.data.dto.Dueño;
import veterinaria.data.data.exceptions.ExceptionDao;
import veterinaria.data.data.exceptions.ExceptionManager;

import java.util.List;

@Transactional
@Service
public class MgrDueño implements ImgrDueño {

    private DueñoDaoInterface dueñoDao;

    public MgrDueño(DueñoDaoInterface dueñoDao) {
        this.dueñoDao = dueñoDao;
    }

    @Override
    public void Save(Dueño dueño) throws ExceptionManager {

        try{
            Dueño d = dueñoDao.getById(dueño.getIdpropietario());
            if(d == null) {
                dueñoDao.insert(dueño);
            }else {
                throw new ExceptionManager("El dueño ya esta Registrado");
            }

        }catch (Exception e){
            throw new ExceptionManager(e);

        }

    }

    @Override
    public void Delete(Dueño dueño) throws ExceptionManager {

        try {
            Dueño d = dueñoDao.getById(dueño.getIdpropietario());
            if (d == null) {

                throw new ExceptionManager("El dueño no se encuentra en el Registro");
            } else {
                dueñoDao.delete(dueño);
            }

        }catch (Exception e){
            throw new ExceptionManager(e);

        }

    }

    @Override
    public void Update(Dueño dueño) throws ExceptionManager {

        try {
            Dueño d = dueñoDao.getById(dueño.getIdpropietario());
            if (d == null) {

                throw new ExceptionManager("El dueño no se encuentra en el Registro");
            } else {
                dueñoDao.update(dueño);
            }

        }catch (Exception e){
            throw new ExceptionManager(e);

        }

    }

    @Override
    public List<Dueño> lista() throws ExceptionManager {

        try {
            return  dueñoDao.lista();
        } catch (ExceptionDao e) {

            throw new ExceptionManager(e);
        }catch (Exception e){
            throw new ExceptionManager(e);

        }
    }
}
