/*
 * Created on 27 oct. 2014 ( Time 17:22:41 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package eventmanager.business.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "EVENTS"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="EVENTS", schema="APP" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="EventsEntity.countAll", query="SELECT COUNT(x) FROM EventsEntity x" ),
  @NamedQuery ( name="EventsEntity.selectByUser", query="SELECT * FROM EventsEntity x WHERE x.users == :users")
} )
public class EventsEntity implements Serializable {

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
    @Column(name="ADRESSE", nullable=false, length=50)
    private String     adresse      ;

    @Temporal(TemporalType.DATE)
    @Column(name="DATEDEB", nullable=false)
    private Date       datedeb      ;

    @Temporal(TemporalType.DATE)
    @Column(name="DATEFIN", nullable=false)
    private Date       datefin      ;

    @Column(name="VISIBLE", nullable=false)
    private short      visible      ;

    @Column(name="NOM", nullable=false, length=20)
    private String     nom          ;

    @Column(name="DESCRIPTION", length=50)
    private String     description  ;

	// "hote" (column "HOTE") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToMany(targetEntity=ParticipantsEntity.class)
    @JoinTable(name="REGISTRATION", 
      joinColumns=@JoinColumn(name="IDEVENT", referencedColumnName="ID"),
      inverseJoinColumns=@JoinColumn(name="IDPARTICIPANT", referencedColumnName="ID")
     ) 

    private List<ParticipantsEntity> listOfParticipants;

    @ManyToOne
    @JoinColumn(name="HOTE", referencedColumnName="EMAIL")
    private UsersEntity users       ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public EventsEntity() {
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
    //--- DATABASE MAPPING : ADRESSE ( VARCHAR ) 
    public void setAdresse( String adresse ) {
        this.adresse = adresse;
    }
    public String getAdresse() {
        return this.adresse;
    }

    //--- DATABASE MAPPING : DATEDEB ( DATE ) 
    public void setDatedeb( Date datedeb ) {
        this.datedeb = datedeb;
    }
    public Date getDatedeb() {
        return this.datedeb;
    }

    //--- DATABASE MAPPING : DATEFIN ( DATE ) 
    public void setDatefin( Date datefin ) {
        this.datefin = datefin;
    }
    public Date getDatefin() {
        return this.datefin;
    }

    //--- DATABASE MAPPING : VISIBLE ( BOOLEAN ) 
    public void setVisible( short visible ) {
        this.visible = visible;
    }
    public short getVisible() {
        return this.visible;
    }

    //--- DATABASE MAPPING : NOM ( VARCHAR ) 
    public void setNom( String nom ) {
        this.nom = nom;
    }
    public String getNom() {
        return this.nom;
    }

    //--- DATABASE MAPPING : DESCRIPTION ( VARCHAR ) 
    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfParticipants( List<ParticipantsEntity> listOfParticipants ) {
        this.listOfParticipants = listOfParticipants;
    }
    public List<ParticipantsEntity> getListOfParticipants() {
        return this.listOfParticipants;
    }

    public void setUsers( UsersEntity users ) {
        this.users = users;
    }
    public UsersEntity getUsers() {
        return this.users;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(adresse);
        sb.append("|");
        sb.append(datedeb);
        sb.append("|");
        sb.append(datefin);
        sb.append("|");
        sb.append(visible);
        sb.append("|");
        sb.append(nom);
        sb.append("|");
        sb.append(description);
        return sb.toString(); 
    } 

}
