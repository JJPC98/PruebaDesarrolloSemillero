package veterinaria.data.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import veterinaria.data.data.dto.Dueño;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DueñoMapper implements RowMapper<Dueño> {

    @Override
    public Dueño mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dueño d = new Dueño();
        d.setIdpropietario(rs.getInt("idpropietario"));
        d.setTipoid(rs.getString("tipoid"));
        d.setNombre(rs.getString("nombre"));
        d.setCiudad(rs.getString("ciudad"));
        d.setDireccion(rs.getString("direccion"));
        d.setTelefono(rs.getString("telefono"));
        return d;
    }
}
