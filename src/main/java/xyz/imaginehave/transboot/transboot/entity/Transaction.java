package xyz.imaginehave.transboot.transboot.entity;

import javax.persistence.*;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;

import xyz.imaginehave.transboot.transboot.entity.TransectUser.TransectUserId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transaction extends Audit {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8204157116215472352L;

	@EmbeddedId
	private TransactionId id;
    
    private BigDecimal amount;
    

	public TransactionId getId() {
		return id;
	}

	public void setId(TransactionId id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


    @Override
    public String toString()
    {
       return new ToStringBuilder(this)
          .append("id", this.id)
          .append("amount", this.amount)
          .toString();
    }
    
	@Embeddable
	public static class TransactionId implements Serializable {


		private static final long serialVersionUID = -5536212139875110322L;
		
	    @ManyToOne(optional = false)
	    @JoinColumns({
	        @JoinColumn(
	            name = "payer",
	            referencedColumnName = "account_name")
	    })
	    private Account payer;
	    
	    @ManyToOne(optional = false)
	    @JoinColumns({
	        @JoinColumn(
	            name = "payee",
	            referencedColumnName = "account_name")
	    })
	    private Account payee;
	    
	    
	    @ManyToOne(optional = false)
	    @JoinColumns({
	        @JoinColumn(
	            name = "user_name",
	            referencedColumnName = "user_name"),
	        @JoinColumn(
	            name = "email",
	            referencedColumnName = "email")
	    })
	    private TransectUser transectUser;
	    
	    @Column
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd") 
	    private LocalDate date;

		public TransactionId() {
			
		}

		public Account getPayer() {
			return payer;
		}

		public void setPayer(Account payer) {
			this.payer = payer;
		}

		public Account getPayee() {
			return payee;
		}

		public void setPayee(Account payee) {
			this.payee = payee;
		}

		public TransectUser getTransectUser() {
			return transectUser;
		}

		public void setTransectUser(TransectUser transectUser) {
			this.transectUser = transectUser;
		}

		public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}
		
	    @Override
	    public int hashCode()
	    {
	       return new HashCodeBuilder()
	          .append(this.transectUser)
	          .append(this.payer)
	          .append(this.payee)
	          .append(this.date)
	          .toHashCode();
	    }
	    
	    @Override
	    public String toString()
	    {
	       return new ToStringBuilder(this)
	 	          .append("user", this.transectUser)
		          .append("payer", this.payer)
		          .append("payee", this.payee)
		          .append("date", this.date)
	          .toString();
	    }
	    
	    
	    @Override
	    public boolean equals(Object obj)
	    {
	       if (obj instanceof TransactionId == false)
	       {
	         return false;
	       }
	       final TransactionId otherObject = (TransactionId) obj;

	       return new EqualsBuilder()
 	          .append(this.transectUser, otherObject.transectUser)
	          .append(this.payer, otherObject.payer)
	          .append(this.payee, otherObject.payee)
	          .append(this.date, otherObject.date)
	          .isEquals();
	    }		
	}
}