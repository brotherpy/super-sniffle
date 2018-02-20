package lt.dao;



import java.time.LocalDate;
import java.util.List;
import lt.models.Cuota;
import lt.models.TipoPlan;



import org.hibernate.query.Query;

public class DaoCuota extends GenericDao<Cuota> {

    public DaoCuota() {
        super(Cuota.class);
    }

    @Override
    public List<Cuota> recuperarPorFiltro(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     public List<Cuota> recuperarCliente(Integer idCliente, Integer poliza) {
        session.beginTransaction();
        Query<Cuota> query = session.createQuery(" FROM " + clase.getName() + " where (cliente_id) = :cliente_id and (poliza_id) =:desde and (cuota_estado) =:estado " );
        query.setParameter("cliente_id", idCliente);
        query.setParameter("desde", poliza);
        query.setParameter("estado", false);
        List<Cuota> cuotas = query.getResultList();
        close();
        
        return cuotas;
    }
     public List<Cuota> recuperarSoloFalse() {
        session.beginTransaction();
        Query<Cuota> query = session.createQuery(" FROM " + clase.getName() + " where cuota_estado = 'false' " );
        List<Cuota> cuotas = query.getResultList();
        close();
        
        return cuotas;
    }
       public List<Cuota> recuperarPorPolizaSoloFalse(TipoPlan plan) {
        session.beginTransaction();
        Query<Cuota> query = session.createQuery(" FROM " + clase.getName() + " where (poliza_id) = :poliza_id and cuota_estado = 'false' " );
        query.setParameter("poliza_id", plan.getCodigo());
        List<Cuota> cuotas = query.getResultList();
        close();
        
        return cuotas;
    }
              public List<Cuota> recuperarPorPolizaSoloFalseFechada(TipoPlan plan, LocalDate fecha) {
        session.beginTransaction();
        //"''"
        Query<Cuota> query = session.createQuery(" FROM " + clase.getName() + " where (poliza_id) = :poliza_id and cuota_estado = 'false' and cuota_vencimiento < :fecha " );
        query.setParameter("poliza_id", plan.getCodigo());
        query.setParameter("fecha", fecha);
        
        List<Cuota> cuotas = query.getResultList();
        close();
        
        return cuotas;
    }
      public Cuota recuperarCoutaPorNumero(Integer nroCuota) {
        session.beginTransaction();
        Query<Cuota> query = session.createQuery(" FROM " + clase.getName() + " where (cuota_numero) = :cuota_numero " );
        query.setParameter("cuota_numero", nroCuota);
        Cuota cuota = query.uniqueResult();
        close();
        
        return cuota;
    }
}
