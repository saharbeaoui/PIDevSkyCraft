/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skycraft.entities;

/**
 *
 * @author sinad
 */
public class Evenement {
    private int id;
    private String detail,commentaire,date_debut,date_fin;

    public Evenement(int id, String detail, String commentaire, String date_debut, String date_fin) {
        this.id = id;
        this.detail = detail;
        this.commentaire = commentaire;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public int getId() {
        return id;
    }

    public String getDetail() {
        return detail;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", detail=" + detail + ", commentaire=" + commentaire + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';
    }
    
    
}
