package org.fit.pis.back;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.fit.pis.data.*;
import org.fit.pis.service.CarManager;

@ManagedBean
@SessionScoped
public class FindCarBean
{
    private Car car;
    private String find;
    private boolean found;
    @EJB
    private CarManager carMgr;

    public FindCarBean()
    {
        car = new Car();
        found = false;
    }
    
    public Car getCar()
    {
        return car;
    }

    public void setCar(Car car)
    {
        this.car = car;
    }
    
    public List<Car> autocomplete(Object event) 
    {
        String pref = event.toString();
        return carMgr.findBegining(pref);
    }

    public String getFind()
    {
        return find;
    }

    public void setFind(String find)
    {
        this.find = find;
    }

    public boolean isFound()
    {
        return found;
    }

    public void setFound(boolean found)
    {
        this.found = found;
    }

    public String findCar()
    {
        car = carMgr.find(find);
        found = true;
        return "ok";
    }
    
    public String clearSearch()
    {
        found = false;
        return "ok";
    }

}
