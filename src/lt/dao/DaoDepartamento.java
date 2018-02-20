package lt.dao;



import java.util.List;

import lt.models.Departamentos;


import org.hibernate.query.Query;

public class DaoDepartamento extends GenericDao<Departamentos> {

    public DaoDepartamento() {
        super(Departamentos.class);
    }

    @Override
    public List<Departamentos> recuperarPorFiltro(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



 
}
