/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import javabeans.Tema;
import resources.Datos;

@Named("daoTemas")
@RequestScoped
 public class DaoTemasImpl implements DaoTemas { 
    @Override
	public List<Tema> obtenerTemas(){
        List<Tema> lista=new ArrayList<> ();
           
        try(Connection con=Datos.getConnection("reflibros")) {                       
            //Paso 2: Envio SQL
            String sql="select * from temas";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);            
            while(rs.next()){
                lista.add(new Tema(rs.getInt("idTema"),rs.getString("tema")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista;
    }
}
