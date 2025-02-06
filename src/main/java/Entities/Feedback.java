package Entities;
import java.util.Date;
import java.util.List;

public class Feedback {
    private int feedback_id;
    private int note;
    private String commentaire;
    private Date date_feedback;
    private Evenement evenement_id;
    private Utilisateur utilisateur_id;

    public Feedback() {}

    public Feedback(int feedback_id, int note, String commentaire, Date date_feedback, Evenement evenement_id, Utilisateur utilisateur_id) {
        this.feedback_id = feedback_id;
        this.note = note;
        this.commentaire = commentaire;
        this.date_feedback = date_feedback;
        this.evenement_id = evenement_id;
        this.utilisateur_id = utilisateur_id;
    }

    public Feedback(int note, String commentaire, Date date_feedback, Evenement evenement_id, Utilisateur utilisateur_id) {
        this.note = note;
        this.commentaire = commentaire;
        this.date_feedback = date_feedback;
        this.evenement_id = evenement_id;
        this.utilisateur_id = utilisateur_id;
    }

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDate_feedback() {
        return date_feedback;
    }

    public void setDate_feedback(Date date_feedback) {
        this.date_feedback = date_feedback;
    }

    public Evenement getEvenement_id() {
        return evenement_id;
    }

    public void setEvenement_id(Evenement evenement_id) {
        this.evenement_id = evenement_id;
    }

    public Utilisateur getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(Utilisateur utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    @Override
    public String toString() {
        return "Feedback{" +
            "feedback_id=" + feedback_id +
            ", note=" + note +
            ", commentaire='" + commentaire + '\'' +
            ", date_feedback=" + date_feedback +
            ", evenement_id=" + evenement_id +
            ", utilisateur_id=" + utilisateur_id +
            '}';
    }


}
