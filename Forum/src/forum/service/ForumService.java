/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.entity.Forum;
import java.util.List;

/**
 *
 * @author admin
 */
public interface ForumService {
    
    public void ajouter(Forum f);
    
    public void modifier(Forum f);
    
    public void supprimer(Forum f);
    
    public Forum rechercherParId(long id);
    
    public List<Forum> listerTous();
}
