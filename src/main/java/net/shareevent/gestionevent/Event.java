package net.shareevent.gestionevent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

class EventICS {
    private ZonedDateTime dateDebut;
    private ZonedDateTime dateFin;
    private String titre;
    private String description;
    private int duree;

    /**
     * @param dateDebut
     * @param dateFin
     * @param titre
     * @param description
     * @param duree
     */
    public EventICS(ZonedDateTime dateDebut, ZonedDateTime dateFin, String titre, String description, int duree) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.titre = titre;
        this.description = description;
        this.duree = duree;
    }

    /**
     * @return the dateDebut
     */
    public ZonedDateTime getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    void setDateDebut(ZonedDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return the dateFin
     */
    public ZonedDateTime getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    void setDateFin(ZonedDateTime dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the duree
     */
    public int getDuree() {
        return duree;
    }

    /**
     * @param duree the duree to set
     */
    void setDuree(int duree) {
        this.duree = duree;
    }

}