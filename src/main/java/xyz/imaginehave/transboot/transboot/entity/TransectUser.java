package xyz.imaginehave.transboot.transboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class TransectUser extends Audit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6030268468060116562L;
	
	@EmbeddedId
	private TransectUserId id;
	
	public TransectUserId getId() {
		return id;
	}

	public void setId(TransectUserId id) {
		this.id = id;
	}


	@Embeddable
	public static class TransectUserId implements Serializable {


		private static final long serialVersionUID = -5536212139875110322L;

		@Column(name = "user_name")
		private String userName;
		
		@Column(name = "email")
		private String email;
		
		public TransectUserId() {
			
		}

		public TransectUserId(String userName, String email) {
			this.userName = userName;
			this.email = email;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
	    @Override
	    public int hashCode()
	    {
	       return new HashCodeBuilder()
	          .append(this.userName)
	          .append(this.email)
	          .toHashCode();
	    }
	    
	    @Override
	    public String toString()
	    {
	       return new ToStringBuilder(this)
	          .append("name", this.userName)
	          .append("email", this.email)
	          .toString();
	    }
	    
	    
	    @Override
	    public boolean equals(Object obj)
	    {
	       if (obj instanceof TransectUserId == false)
	       {
	         return false;
	       }
	       final TransectUserId otherObject = (TransectUserId) obj;

	       return new EqualsBuilder()
	          .append(this.userName, otherObject.userName)
	          .append(this.email, otherObject.email)
	          .isEquals();
	    }
		
	}

}

