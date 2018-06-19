package com.meumenu.persistence;

import com.meumenu.model.Receita;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author david
 */
public class ReceitaDao {

    private EntityManager em;

    public ReceitaDao() {
        em = Persistence.createEntityManagerFactory("meumenuPU").createEntityManager();
    }

    public void save(Receita receita) {
        if (receita.getId() == null) {
            em.persist(receita);
        } else {
            em.merge(receita);
        }

    }

    public Receita findById(Integer id) {
        return em.find(Receita.class, id);
    }

    public void remove(Receita receita){
        this.removeById(receita.getId());
    }
    
    public void removeById(Integer id) {
        em.remove(em.find(Receita.class, id));
    }
    
    public List<Receita> getAll(){
        return em.createQuery("SELECT r FROM Receita r").getResultList();
    }
    
    public List<Receita> getByNameOrText(String value){
         return em.createQuery("SELECT r FROM Receita r\n"
                 + "WHERE r.nome like '%"
                 + value
                 + "%' "
                 + "OR r.texto like '%"
                 + value
                 + "%' ").getResultList();
    }
}
