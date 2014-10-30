/*
 * Created on 27 oct. 2014 ( Time 17:22:42 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package eventmanager.business.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "PARTICIPANTS"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="PARTICIPANTS", schema="APP" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ParticipantsEntity.countAll", query="SELECT COUNT(x) FROM ParticipantsEntity x" ),
  @NamedQuery ( name="ParticipantsEntity.selectByEmail", query="SELECT x FROM ParticipantsEntity x where email = :email")
} )
public class ParticipantsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="NOM", nullable=false, length=24)
    private String     nom          ;

    @Column(name="PRENOM", nullable=false, length=24)
    private String     prenom       ;

    @Column(name="EMAIL", nullable=false, length=30)
    private String     email        ;

    @Column(name="SOCIETE", length=24)
    private String     societe      ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToMany(mappedBy="listOfParticipants", targetEntity=EventsEntity.class, fetch=FetchType.EAGER)
    private List<EventsEntity> listOfEvents;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public ParticipantsEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : NOM ( VARCHAR ) 
    public void setNom( String nom ) {
        this.nom = nom;
    }
    public String getNom() {
        return this.nom;
    }

    //--- DATABASE MAPPING : PRENOM ( VARCHAR ) 
    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }
    public String getPrenom() {
        return this.prenom;
    }

    //--- DATABASE MAPPING : EMAIL ( VARCHAR ) 
    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    //--- DATABASE MAPPING : SOCIETE ( VARCHAR ) 
    public void setSociete( String societe ) {
        this.societe = societe;
    }
    public String getSociete() {
        return this.societe;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfEvents( List<EventsEntity> listOfEvents ) {
        this.listOfEvents = listOfEvents;
    }
    public List<EventsEntity> getListOfEvents() {
        return this.listOfEvents;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(nom);
        sb.append("|");
        sb.append(prenom);
        sb.append("|");
        sb.append(email);
        sb.append("|");
        sb.append(societe);
        return sb.toString(); 
    } 

}
