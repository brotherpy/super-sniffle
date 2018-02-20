package lt.dao;



import java.util.List;


import org.hibernate.query.Query;

public class DaoClienteListado extends GenericDao<ListadoCliente> {

    public DaoClienteListado() {
        super(ListadoCliente.class);
    }



    @Override
    public List<ListadoCliente> recuperarPorFiltro(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}