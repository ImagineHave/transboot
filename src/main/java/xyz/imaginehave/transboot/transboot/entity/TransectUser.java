package xyz.imaginehave.transboot.transboot.entity;


import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class TransectUser extends Audit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6030268468060116562L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "user_name", nullable = false)
	private String userName;

	private String key;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
    public String toString()
    {
       return new ToStringBuilder(this)
          .append("id", this.id)
          .append("userid", this.userName)
          .toString();
    }
    
    
    @Override
    public int hashCode()
    {
       return new HashCodeBuilder()
    		   .append(this.id)
    		   .append(this.userName)
    		   .toHashCode();
    }
    
    @Override
    public boolean equals(Object obj)
    {
       if (obj instanceof TransectUser == false)
       {
         return false;
       }
       final TransectUser otherObject = (TransectUser) obj;

       return new EqualsBuilder()
          .append(this.userName, otherObject.userName)
          .append(this.id, otherObject.id)
          .isEquals();
    }

}

