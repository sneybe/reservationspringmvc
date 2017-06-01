/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author formation
 */
@Entity
public class Utilisateur implements Serializable {

    public enum TypeUtilisateur{
      ADMIN,
      CLIENT
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String identifiants;

    @Enumerated(EnumType.STRING)
    private TypeUtilisateur typeUtil;

    public TypeUtilisateur getTypeUtil() {
        return typeUtil;
    }

    public void setTypeUtil(TypeUtilisateur typeUtil) {
        this.typeUtil = typeUtil;
    }
    
    public String getIdentifiants() {
        return identifiants;
    }

    public void setIdentifiants(String login) {
        this.identifiants = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private String motDePasse;
    private String email;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "reservation.entity.Utilisateur[ id=" + id + " ]";
    }
    
}
