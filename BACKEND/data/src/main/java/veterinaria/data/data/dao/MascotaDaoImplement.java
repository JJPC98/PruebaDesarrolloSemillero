package veterinaria.data.data.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import veterinaria.data.data.dto.Mascota;
import veterinaria.data.data.exceptions.ExceptionDao;
import veterinaria.data.data.mapper.MascotaMapper;

import java.util.List;

@Repository
public class MascotaDaoImplement implements MascotaDaoInterface{

    private JdbcTemplate jdbcTemplate;

    public MascotaDaoImplement(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Mascota m) throws ExceptionDao {
        String INSERT = "insert into mascota(idmascota, nombre, especie, raza, fechanacimiento, id_propietario, fecharegistro) " +
                "values (?,?,?,?,?,?,?)";
        try {
            jdbcTemplate.update(INSERT,
                    m.getIdmascota(),
                    m.getNombre(),
                    m.getEspecie(),
                    m.getRaza(),
                    m.getFechanacimiento(),
                    m.getId_propietario(),
                    m.getFecharegistro()

            );

        } catch (Exception e) {
            throw new ExceptionDao(e);

        }
    }

    @Override
    public void update(Mascota m) throws ExceptionDao {
        String UPDATE = "update mascota set nombre = ?, especie = ?, raza = ?, fechanacimiento = ?, id_propietario = ?, fecharegistro = ? " +
                "where idmascota = ?";

        try {
            jdbcTemplate.update(UPDATE,
                    m.getNombre(),
                    m.getEspecie(),
                    m.getRaza(),
                    m.getFechanacimiento(),
                    m.getId_propietario(),
                    m.getFecharegistro(),
                    m.getIdmascota()

            );


        } catch (Exception e) {
            throw new ExceptionDao(e);

        }

    }

    @Override
    public void delete(Mascota m) throws ExceptionDao {
        String DELETE = "delete from mascota where idmascota = ?";

        try {
            jdbcTemplate.update(DELETE,
                    m.getIdmascota()
            );

        } catch (Exception e) {
            throw new ExceptionDao(e);

        }


    }

    @Override
    public Mascota getById(int idmascota) throws ExceptionDao {
        String SELECT = "select idmascota, nombre, especie, raza, fechanacimiento, id_propietario, fecharegistro " +
                "from mascota where idmascota = ?";
        try{

            return jdbcTemplate.queryForObject(SELECT, new MascotaMapper(),idmascota);
        }

        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Mascota> lista() throws ExceptionDao {

        String SELECT = "select idmascota, nombre, especie, raza, fechanacimiento, id_propietario, fecharegistro from mascota ";
        List<Mascota> lista = null;

        try {
            lista=jdbcTemplate.query(SELECT,new MascotaMapper());
        } catch (Exception e) {
            throw new ExceptionDao(e);

        }
        return lista;
    }
}
