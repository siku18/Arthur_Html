/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.dao;

import forum.entity.Message;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public class MessageDAOJpaImpl implements MessageDAO{
    
    @Override
    public void ajouter(Message m){
        EntityManager em = Persistence.createEntityManagerFactory("ForumPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        
    }
    
    @Override
    public void modifier(Message m){
        EntityManager em = Persistence.createEntityManagerFactory("ForumPU").createEntityManager();
        em.getTransaction().begin();
        em.merge(m);
        em.getTransaction().commit();
    }
    
    @Override
    public void supprimer(Message m){
        EntityManager em = Persistence.createEntityManagerFactory("ForumPU").createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Message m WHERE m.id="+m.getId()).executeUpdate();
        em.getTransaction().commit();
    }
    
    @Override
    public List<Message> listerTous(){
        EntityManager em = Persistence.createEntityManagerFactory("ForumPU").createEntityManager();
        
        return em.createQuery("SELECT m FROM Message m").getResultList();
    }
    
    @Override
    public Message rechercherParId(long id){
        EntityManager em = Persistence.createEntityManagerFactory("ForumPU").createEntityManager();
        
        return em.find(Message.class, id);
    }
}
