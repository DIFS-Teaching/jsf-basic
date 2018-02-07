package org.fit.pis.back;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.fit.pis.data.*;
import org.fit.pis.service.PersonManager;


@ManagedBean
@SessionScoped
public class PersonBean
{
	@EJB
	private PersonManager personMgr;
    private Person person;
    private Car car;
    
    public PersonBean()
    {
        person = new Person();
        car = new Car();
    }
    
    /**
     * @return the person
     */
    public Person getPerson()
    {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person)
    {
        this.person = person;
    }
    
    public List<Person> getPeople()
    {
		return personMgr.findAll();
    }
    
    public Car getCar()
    {
        return car;
    }

    public void setCar(Car car)
    {
        this.car = car;
    }

   //====================================================
    
	public String actionNew()
	{
		person = new Person();
		return "new";
	}
	
	public String actionInsertNew()
    {
        personMgr.save(person);
        return "insert";
    }
    
    public String actionUpdate()
    {
        personMgr.save(person);
        return "update";
    }
    
    public String actionEdit(Person person)
    {
    	setPerson(person);
    	return "edit";
    }
    
    public String actionDelete(Person person)
    {
    	personMgr.remove(person);
    	return "delete";
    }

    public String actionCarNew()
    {
        car = new Car();
        return "newcar";
    }
    
    public String actionCarAdd()
    {
        car.setOwner(person);
        person.getCars().add(car);
        return "add";
    }
    
    public String actionCarDel(Car car)
    {
        person.getCars().remove(car);
        return "delete";
    }
    
}
