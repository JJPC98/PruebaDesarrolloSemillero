package veterinaria.data.data.manager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import veterinaria.data.data.dao.MascotaDaoInterface;
import veterinaria.data.data.dto.Mascota;
import veterinaria.data.data.exceptions.ExceptionDao;
import veterinaria.data.data.exceptions.ExceptionManager;

import java.util.List;

@Transactional
@Service
public class MgrMascota implements ImgrMascota{

    private MascotaDaoInterface mascotaDao;

    public MgrMascota(MascotaDaoInterface mascotaDao) {
        this.mascotaDao = mascotaDao;
    }

    @Override
    public void Save(Mascota mascota) throws ExceptionManager {
        try{
            Mascota m = mascotaDao.getById(mascota.getIdmascota());
            if(m == null) {
                mascotaDao.insert(mascota);
            }else {
                throw new ExceptionManager("La mascota ya esta Registrada");
            }

        }catch (Exception e){
            throw new ExceptionManager(e);

        }
    }

    @Override
    public void Delete(Mascota mascota) throws ExceptionManager {

        try {
            Mascota m = mascotaDao.getById(mascota.getIdmascota());
            if (m == null) {

                throw new ExceptionManager("La mascota no se encuentra en el Registro");
            } else {
                mascotaDao.delete(mascota);
            }

        }catch (Exception e){
            throw new ExceptionManager(e);

        }

    }

    @Override
    public void Update(Mascota mascota) throws ExceptionManager {
        try {
            Mascota m = mascotaDao.getById(mascota.getIdmascota());
            if (m == null) {

                throw new ExceptionManager("La mascota no se encuentra en el Registro");
            } else {
                mascotaDao.update(mascota);
            }

        }catch (Exception e){
            throw new ExceptionManager(e);

        }

    }

    @Override
    public List<Mascota> lista() throws ExceptionManager {

        try {
            return  mascotaDao.lista();
        } catch (ExceptionDao e) {
            throw new ExceptionManager(e);

        }catch (Exception e){
            throw new ExceptionManager(e);

        }
    }
}
