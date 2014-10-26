/*
 * Created on 26 oct. 2014 ( Time 19:52:14 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package eventmanager.business.bean.jpa;
import java.io.Serializable;

import javax.persistence.*;

/**
 * Composite primary key for entity "RegistrationEntity" ( stored in table "REGISTRATION" )
 *
 * @author Telosys Tools Generator
 *
 */
 @Embeddable
public class RegistrationEntityKey implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES 
    //----------------------------------------------------------------------
    @Column(name="IDEVENT", nullable=false)
    private Integer    idevent      ;
    
    @Column(name="IDPARTICIPANT", nullable=false)
    private Integer    idparticipant ;
    

    //----------------------------------------------------------------------
    // CONSTRUCTORS
    //----------------------------------------------------------------------
    public RegistrationEntityKey() {
        super();
    }

    public RegistrationEntityKey( Integer idevent, Integer idparticipant ) {
        super();
        this.idevent = idevent ;
        this.idparticipant = idparticipant ;
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR KEY FIELDS
    //----------------------------------------------------------------------
    public void setIdevent( Integer value ) {
        this.idevent = value;
    }
    public Integer getIdevent() {
        return this.idevent;
    }

    public void setIdparticipant( Integer value ) {
        this.idparticipant = value;
    }
    public Integer getIdparticipant() {
        return this.idparticipant;
    }


    //----------------------------------------------------------------------
    // equals METHOD
    //----------------------------------------------------------------------
	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		RegistrationEntityKey other = (RegistrationEntityKey) obj; 
		//--- Attribute idevent
		if ( idevent == null ) { 
			if ( other.idevent != null ) 
				return false ; 
		} else if ( ! idevent.equals(other.idevent) ) 
			return false ; 
		//--- Attribute idparticipant
		if ( idparticipant == null ) { 
			if ( other.idparticipant != null ) 
				return false ; 
		} else if ( ! idparticipant.equals(other.idparticipant) ) 
			return false ; 
		return true; 
	} 


    //----------------------------------------------------------------------
    // hashCode METHOD
    //----------------------------------------------------------------------
	public int hashCode() { 
		final int prime = 31; 
		int result = 1; 
		
		//--- Attribute idevent
		result = prime * result + ((idevent == null) ? 0 : idevent.hashCode() ) ; 
		//--- Attribute idparticipant
		result = prime * result + ((idparticipant == null) ? 0 : idparticipant.hashCode() ) ; 
		
		return result; 
	} 


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
		StringBuffer sb = new StringBuffer(); 
		sb.append(idevent); 
		sb.append("|"); 
		sb.append(idparticipant); 
        return sb.toString();
    }
}
