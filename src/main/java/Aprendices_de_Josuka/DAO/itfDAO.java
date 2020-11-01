package Aprendices_de_Josuka.DAO;

import java.util.List;

import Aprendices_de_Josuka.LD.Administrador;

public interface itfDAO 
{
	public void guardarObjeto (Object objeto);

	public void cerrarConexion();
	public List<Administrador> getAdmin();
	
	
}
