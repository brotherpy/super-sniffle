/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dao;

import java.util.List;
import lt.util.ConnectionHelper;

import org.hibernate.Session;
import org.hibernate.query.Query;


/**
 *
 * @author brother
 */
abstract public class GenericDao<T> {

    protected Session session;
    protected Class<T> clase;

    public GenericDao(Class<T> clase) {
        this.clase = clase;
        ConnectionHelper.getSessionFactory().openSession();
        session = ConnectionHelper.getSessionFactory().getCurrentSession();
    }

    public void insertar(T entity) throws Exception {
        session.beginTransaction();
        session.save(entity);
    }

    public void actualizar(T entity) throws Exception {
        session.beginTransaction();
        session.update(entity);
    }

    public void eliminar(T entity) throws Exception {
        session.beginTransaction();
        session.delete(entity);
    }

    public T recuperarPorId(Integer id) {
        session.beginTransaction();
        T result = (T) session.get(clase, id);
        close();
        return result;
    }

    public List<T> recuperarTodo() {
        session.beginTransaction();
        Query<T> q = session.createQuery("from " + clase.getName()+" ");
        List<T> results = q.list();
        close();
        return results;
    }

    abstract public List<T> recuperarPorFiltro(String filtro);

    public void commit() {
        session.getTransaction().commit();
    }

    public void rollback() {
        session.getTransaction().rollback();
    }

    protected void close() {
        session.close();
    }
}
