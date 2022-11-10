package veterinaria.data.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import veterinaria.data.data.dto.Mascota;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MascotaMapper implements RowMapper<Mascota> {
    @Override
    public Mascota mapRow(ResultSet rs, int rowNum) throws SQLException {
        Mascota m = new Mascota();
        m.setIdmascota(rs.getInt("idmascota"));
        m.setNombre(rs.getString("nombre"));
        m.setEspecie(rs.getString("especie"));
        m.setRaza(rs.getString("raza"));
        m.setFechanacimiento(rs.getString("fechanacimiento"));
        m.setId_propietario(rs.getInt("id_propietario"));
        m.setFecharegistro(rs.getString("fecharegistro"));
        return m;
    }
}
