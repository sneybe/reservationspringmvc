/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.service;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import reservation.entity.Utilisateur;

/**
 *
 * @author formation
 */
public interface UtilisateurServiceCrud extends CrudRepository<Utilisateur, Long> {
    
    public Utilisateur findByMotDePasseAndIdentifiants(String motd,String log);
    
}
