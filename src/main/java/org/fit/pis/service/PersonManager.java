/**
 * Stateless bean pro pr�ci s daty osoby
 */
package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.Person;


/**
 * @author burgetr
 *
 */
@Stateless
public class PersonManager 
{
    @PersistenceContext
    private EntityManager em;

    public PersonManager() 
    {
    }
    
    public void save(Person p)
    {
    	em.merge(p);
    }
	
    public void remove(Person p)
    {
    	em.remove(em.merge(p));
    }
    
    public List<Person> findAll()
    {
    	return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

}
