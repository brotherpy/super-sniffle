package lt.dao;



import java.util.List;
import lt.models.Cliente;


import org.hibernate.query.Query;

public class DaoCliente extends GenericDao<Cliente> {

    public DaoCliente() {
        super(Cliente.class);
    }

    @Override
    public List<Cliente> recuperarPorFiltro(String filtro) {
        session.beginTransaction();
        Query<Cliente> query = session.createQuery("from "+clase.getName()+" "
						+ "where lower(cli_nombre) like :nombre "
						+ "or lower(cli_apellido) like :apellido "
						+ "order by id");
		query.setParameter("nombre", "%"+filtro.toLowerCase()+"%");
		query.setParameter("apellido", "%"+filtro.toLowerCase()+"%");
		List<Cliente> results = query.getResultList();
		close();
		return results;
    }

 public Cliente recuperarPorCedula(Integer cedula) {
        session.beginTransaction();
        Query query = session.createQuery(" FROM " + clase.getName() + " where (cli_cin) = :cli_cin " );
        query.setParameter("cli_cin", cedula);
        Cliente cliente = (Cliente) query.uniqueResult();
        close();
        
        return cliente;
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
