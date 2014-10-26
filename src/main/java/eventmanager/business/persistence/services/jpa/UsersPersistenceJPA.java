/*
 * Created on 26 oct. 2014 ( Time 19:52:14 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */

package eventmanager.business.persistence.services.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import eventmanager.business.bean.jpa.UsersEntity;
import eventmanager.business.persistence.commons.jpa.GenericJpaService;
import eventmanager.business.persistence.commons.jpa.JpaOperation;
import eventmanager.business.persistence.services.UsersPersistence;

/**
 * JPA implementation for basic persistence operations ( entity "Users" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class UsersPersistenceJPA extends GenericJpaService<UsersEntity, String> implements UsersPersistence {

	/**
	 * Constructor
	 */
	public UsersPersistenceJPA() {
		super(UsersEntity.class);
	}

	@Override
	public UsersEntity load( String email ) {
		return super.load( email );
	}

	@Override
	public boolean delete( String email ) {
		return super.delete( email );
	}

	@Override
	public boolean delete(UsersEntity entity) {
		if ( entity != null ) {
			return super.delete( entity.getEmail() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("UsersEntity.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
