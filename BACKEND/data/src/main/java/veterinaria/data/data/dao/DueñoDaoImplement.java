package veterinaria.data.data.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import veterinaria.data.data.dto.Dueño;
import veterinaria.data.data.exceptions.ExceptionDao;
import veterinaria.data.data.mapper.DueñoMapper;

import java.util.List;

@Repository
public class DueñoDaoImplement implements DueñoDaoInterface{

    private JdbcTemplate jdbcTemplate;

    public DueñoDaoImplement(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Dueño d) throws ExceptionDao {

        String INSERT = "insert into dueño(idpropietario, tipoid, nombre, ciudad, direccion, telefono) values (?,?,?,?,?,?)";

        try {
            jdbcTemplate.update(INSERT,
                    d.getIdpropietario(),
                    d.getTipoid(),
                    d.getNombre(),
                    d.getCiudad(),
                    d.getDireccion(),
                    d.getTelefono()
            );

        } catch (Exception e) {
            throw new ExceptionDao(e);

        }
    }

    @Override
    public void update(Dueño d) throws ExceptionDao {

        String UPDATE = "update dueño set tipoid = ?, nombre = ?, ciudad = ?, direccion = ?, telefono = ? where idpropietario = ?";

        try {
            jdbcTemplate.update(UPDATE,
                    d.getTipoid(),
                    d.getNombre(),
                    d.getCiudad(),
                    d.getDireccion(),
                    d.getTelefono(),
                    d.getIdpropietario()
            );

        } catch (Exception e) {
            throw new ExceptionDao(e);

        }

    }

    @Override
    public void delete(Dueño d) throws ExceptionDao {

        String DELETE = "delete from dueño where idpropietario = ?";

        try {
            jdbcTemplate.update(DELETE,
                    d.getIdpropietario()
            );

        } catch (Exception e) {
            throw new ExceptionDao(e);

        }

    }

    @Override
    public Dueño getById(int idpropietario) throws ExceptionDao {

        String SELECT = "select idpropietario, tipoid, nombre, ciudad, direccion, telefono from dueño where idpropietario = ?";
        try{

            return jdbcTemplate.queryForObject(SELECT, new DueñoMapper(),idpropietario);
        }

        catch(EmptyResultDataAccessException ex){
            return null;
        }

    }

    @Override
    public List<Dueño> lista() throws ExceptionDao {

        String SELECT = "select idpropietario, tipoid, nombre, ciudad, direccion, telefono from dueño ";
        List<Dueño> lista = null;

        try {
            lista=jdbcTemplate.query(SELECT,new DueñoMapper());
        } catch (Exception e) {
            throw new ExceptionDao(e);

        }
        return lista;
    }
}
