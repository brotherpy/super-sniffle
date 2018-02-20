package lt.dao;



import java.util.List;
import lt.models.Cobranza;
import org.hibernate.query.Query;



public class DaoCobros extends GenericDao<Cobranza> {

    public DaoCobros() {
        super(Cobranza.class);
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
   public List<Cobranza> recuperarCuentaDeCliente(Integer idCliente) {
        session.beginTransaction();
        Query<Cobranza> query = session.createQuery(" FROM " + clase.getName() +  " where (cli_codigo) = :cliente_id ");
        query.setParameter("cliente_id", idCliente);
       
        List<Cobranza> cobranzas = query.getResultList();
        close();
        
        return cobranzas;
    }
     public List<Cobranza> recuperarCuentaDeVehiculo(Integer idVehiculo) {
        session.beginTransaction();
        Query<Cobranza> query = session.createQuery(" FROM " + clase.getName() +  " where (vehiculo_ve_codigo) = :vehiculo_id ");
        query.setParameter("vehiculo_id", idVehiculo);
       
        List<Cobranza> cobranzas = query.getResultList();
        close();
        
        return cobranzas;
    }
     
          public List<Cobranza> recuperarPorParametro(String campo, String desde, String hasta) {
           // '" y dp "'  '""'
        session.beginTransaction();
        Query<Cobranza> query = session.createQuery(" FROM " + clase.getName() +  " where "+campo+" between '"+desde+"' and '"+hasta+"' ");
        
        List<Cobranza> cobranzas = query.getResultList();
        close();
        
        return cobranzas;
    }
          
        public List<Cobranza> recuperarPorParametroNative(String campo, String desde, String hasta) {
           // '" y dp "'  '""'
        session.beginTransaction();
        Query<Cobranza> query = session.createSQLQuery(" select * from cobranza where "+campo+" between '"+desde+"' and '"+hasta+"' ").addEntity(Cobranza.class);
        
        List<Cobranza> cobranzas = (List<Cobranza>) query.list();
        close();
        
        return cobranzas;
    }
   
  
    @Override
    public List<Cobranza> recuperarPorFiltro(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
