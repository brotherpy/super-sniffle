package lt.dao;

import java.util.List;
import lt.models.Cliente;
import lt.models.TipoPlan;
import lt.models.Vehiculo;


import org.hibernate.query.Query;

public class DaoTipoPlan extends GenericDao<TipoPlan> {

    public DaoTipoPlan() {
        super(TipoPlan.class);
    }

    @Override
    public List<TipoPlan> recuperarPorFiltro(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public TipoPlan recuperarPorChapa(Vehiculo vehiculo) {
        session.beginTransaction();
        Query query = session.createQuery(" FROM " + clase.getName() + " where (vehiculo_id) = :vehiculo_id and tipo_estado_activo = true " );
        query.setParameter("vehiculo_id", vehiculo.getCodigo());
        TipoPlan plan= (TipoPlan) query.uniqueResult();
        close();
        
        return plan;
    }
    public List<TipoPlan> recuperarPolizaActivaPorIdCliente(Cliente cliente) {
        session.beginTransaction();
        Query<TipoPlan> query =session.createQuery("FROM "+ clase.getName()+" WHERE (cliente_cli_codigo) = :cli_codigo and tipo_estado_activo = true ");
        query.setParameter("cli_codigo", cliente.getCodigo());
        List<TipoPlan> vehiculos = query.getResultList();
        close();
        return vehiculos;
    }
       public TipoPlan recuperarPolizaPorIdVehiculo(Vehiculo   vehiculo) {
        session.beginTransaction();
        Query query =session.createQuery("FROM "+ clase.getName()+" WHERE (vehiculo_id) = :vehiculo_codigo and tipo_estado_activo = true ");
        query.setParameter("vehiculo_codigo", vehiculo.getCodigo());
           TipoPlan plan= (TipoPlan) query.uniqueResult();
        close();
        return plan;
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
     public List<TipoPlan> recuperarPorParametro(String desde,String hasta,String campo){
    
   session.beginTransaction();
        Query<TipoPlan> query = session.createQuery(" FROM " + clase.getName() +  " where "+campo+" between '"+desde+"' and '"+hasta+"' ");
        
        List<TipoPlan> plans = query.getResultList();
        close();
        
        return plans;
    }
 public List<TipoPlan> recuperarPorTipoPlan(String filtro) {
        session.beginTransaction();
        Query<TipoPlan> query = session.createQuery("from  " + clase.getName() + "  where " + 
                "lower(tipo_nombre) like :tipo_nombre");
        query.setParameter("tipo_nombre", "%" + filtro.toLowerCase() + "%");
        List<TipoPlan> result = query.getResultList();
        close();
        

        return result;
    }

}
