package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import model.Contacto;
import resources.Data;

public class DaoContactosImpl implements DaoContactos {
	static DataSource ds;
	static {
		//patr�n service locator
		ds=Data.getDataSource("refcontactos");
		
	}
	
	@Override
	public void altaContacto() {
		try(Connection con=ds.getConnection();){
			String sql="insert into contactos(nombre,email,edad) values(";
			sql+="'jdbc','jdbc@gmail.com',50)";
			Statement st=con.createStatement();
			st.execute(sql);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	@Override
	public void altaContacto(Contacto contacto) {
		/*try(Connection con=DriverManager.getConnection(url,user,pwd);){
			String sql="insert into contactos(nombre,email,edad) values(";
			sql+="'"+contacto.getNombre()+"','"+contacto.getEmail()+"',"+contacto.getEdad()+")";
			Statement st=con.createStatement();
			st.execute(sql);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}*/
		String sql="insert into contactos(nombre,email,edad) values(?,?,?)";
		try(Connection con=ds.getConnection();
			PreparedStatement prep=con.prepareStatement(sql);){	
			//asignar valores a los parametros
			prep.setString(1, contacto.getNombre());
			prep.setString(2, contacto.getEmail());
			prep.setInt(3, contacto.getEdad());
			//ejecutar
			prep.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public List<Contacto> mostrarContactos() {
		List<Contacto> contactos=new ArrayList<>();
		String sql="Select * from contactos"; 
		try (Connection con=ds.getConnection();
				PreparedStatement prep=con.prepareStatement(sql);
				ResultSet rs=prep.executeQuery();){	      
		    while(rs.next()){ 
		    	contactos.add(new Contacto(rs.getInt("IdContacto"),
		    			rs.getString("nombre"),
		    			rs.getString("email"),
		    			rs.getInt("edad")));
	    	}  
	    } catch (SQLException e) {        
	    	e.printStackTrace(); 
	    } 
		return contactos;
	}
	@Override
	public void eliminarContactos(int id) {
		String sql="delete from contactos where idContacto=?";
		try(Connection con=ds.getConnection();
				PreparedStatement prep=con.prepareStatement(sql);
				){	
			prep.setInt(1, id);
			prep.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}