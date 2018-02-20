/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dao;

import java.util.List;
import lt.models.Cliente;
import org.hibernate.query.Query;

/**
 *
 * @author brother
 */
public class DaoInicializacion extends GenericDao<Cliente> {

    public DaoInicializacion() {
        super(Cliente.class);
    }

    @Override
    public List<Cliente> recuperarPorFiltro(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void inicializarTablas(String tabla) {
        session.beginTransaction();
        session.createSQLQuery("TRUNCATE TABLE " + tabla + " RESTART IDENTITY CASCADE ").executeUpdate();
        close();
    }
 

    public List<String> recuperarNombreTablas() {
        session.beginTransaction();
        Query<String> query = session.createSQLQuery("SELECT table_name "
                + "FROM information_schema.tables "
                + "WHERE table_schema='public' "
                + "AND table_type='BASE TABLE'");
        List<String> results = query.getResultList();
        close();
        return results;
    }    


}
