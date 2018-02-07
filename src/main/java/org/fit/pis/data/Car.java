package org.fit.pis.data;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table
public class Car 
{
    @Id
    private String reg;
	private String prod;
	private String type;
	
	@ManyToOne(fetch=EAGER)
	@JsonIgnore
    private Person owner;
	
    public String getProd()
    {
        return prod;
    }
    
    public boolean equals(Object other)
    {
        if (other instanceof Car)
            return ((Car) other).getReg().equals(reg);
        else
            return false;
    }
    
    public void setProd(String prod)
    {
        this.prod = prod;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getReg()
    {
        return reg;
    }
    
    public void setReg(String reg)
    {
        this.reg = reg;
    }

    public Person getOwner()
    {
        return owner;
    }

    public void setOwner(Person owner)
    {
        this.owner = owner;
    }
}