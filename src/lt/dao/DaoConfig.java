package lt.dao;



import java.util.List;
import lt.models.Config;



public class DaoConfig extends GenericDao<Config> {

    public DaoConfig() {
        super(Config.class);
    }

    @Override
    public List<Config> recuperarPorFiltro(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
}
