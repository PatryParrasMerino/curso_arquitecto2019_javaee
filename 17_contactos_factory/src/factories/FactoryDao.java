package factories;

import daos.DaoContactos;
import daos.DaoContactosImpl;
//clase factoria
public class FactoryDao {
	public static DaoContactos getDaoContactos() {
		return new DaoContactosImpl();
	}
}
