package xyz.imaginehave.transboot.transboot.entity;

import javax.persistence.*;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

@Entity
public class Account extends Audit {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8085310684289086942L;

	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "account_name")
    private String accountName;
    
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd") 
    private LocalDate openedDate;
    
    @ManyToOne(optional = false)
    @JoinColumns({
        @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"),
        @JoinColumn(
            name = "user_name",
            referencedColumnName = "user_name")
    })
    private TransectUser transectUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public LocalDate getOpenedDate() {
		return openedDate;
	}

	public void setOpenedDate(LocalDate openedDate) {
		this.openedDate = openedDate;
	}

	public TransectUser getTransectUser() {
		return transectUser;
	}

	public void setTransectUser(TransectUser transectUser) {
		this.transectUser = transectUser;
	}
	
    @Override
    public String toString()
    {
       return new ToStringBuilder(this)
    		   .append("id", this.id)
    		   .append("accountName", this.accountName)
    		   .append("openedDate", this.openedDate)
    		   .append("transectUser", this.transectUser)
    		   .toString();
    }
    
    @Override
    public int hashCode()
    {
       return new HashCodeBuilder()
    		   .append(this.id)
    		   .append(this.accountName)
    		   .append(this.openedDate)
    		   .append(this.transectUser)
    		   .toHashCode();
    }
    
    @Override
    public boolean equals(Object obj)
    {
       if (obj instanceof Account == false)
       {
         return false;
       }
       final Account otherObject = (Account) obj;

       return new EqualsBuilder()
          .append(this.id, otherObject.id)
          .isEquals();
    }

}