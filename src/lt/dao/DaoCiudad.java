package lt.dao;



import java.util.List;


import lt.models.Distritos;


import org.hibernate.query.Query;

public class DaoCiudad extends GenericDao<Distritos> {

    public DaoCiudad() {
        super(Distritos.class);
    }

    @Override
    public List<Distritos> recuperarPorFiltro(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Distritos> recuperarDistritosPorDepartamento(Integer id){
        session.beginTransaction();
        Query<Distritos> query = session.createQuery(" FROM " + clase.getName() +  " where (departamento_id) = :dto_id ");
        query.setParameter("dto_id", id);
       
        List<Distritos> distritos = query.getResultList();
        close();
        
        return distritos;
    }
        public Distritos recuperarDistritosPorParametro(String ciudad){
        session.beginTransaction();
        Query query = session.createQuery(" FROM " + clase.getName() +  " where (ciudades) = :ciudad ");
        query.setParameter("ciudad", ciudad);
       
        Distritos distrito = (Distritos) query.getSingleResult();
        close();
        
        return distrito;
    }

  
 
}
