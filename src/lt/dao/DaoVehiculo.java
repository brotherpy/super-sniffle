package lt.dao;



import java.util.List;
import lt.models.Cliente;
import lt.models.Vehiculo;


import org.hibernate.query.Query;

public class DaoVehiculo extends GenericDao<Vehiculo> {



    public DaoVehiculo() {
        super(Vehiculo.class);
    }

    @Override
    public List<Vehiculo> recuperarPorFiltro(String filtro) {
        session.beginTransaction();
        Query<Vehiculo> query = session.createQuery("from " + clase.getName() + " where "
                + "(ve_placa) like :ve_placa" );
        query.setParameter("ve_placa", "%"+filtro+"%");
        List<Vehiculo> result = query.getResultList();
        close();
        return result;
    }
 public List<Vehiculo> recuperarVehiculoPorIdCliente(Cliente cliente) {
        session.beginTransaction();
        Query<Vehiculo> query =session.createQuery("FROM "+ clase.getName()+" WHERE (cli_codigo) = :cli_codigo ");
        query.setParameter("cli_codigo", cliente.getCodigo());
        List<Vehiculo> vehiculos = query.getResultList();
        close();
        return vehiculos;
    }
 public Vehiculo recuperarPorChapa(String chapa) {
        session.beginTransaction();
        Query query = session.createQuery(" FROM " + clase.getName() + " where (ve_placa) = :ve_placa " );
        query.setParameter("ve_placa", chapa);
        Vehiculo vehiculo = (Vehiculo) query.uniqueResult();
        close();
        
        return vehiculo;
    }
 
     public Integer recuperarUltimoID() {
        session.beginTransaction();
         Integer query = (Integer) session.createQuery("SELECT max(id) FROM " + clase.getName() + " ")
                .getSingleResult();
        if(query==null){
            query = Integer.parseInt("0");
        }
        close();
        return query;
    }

    
    }


