package xyz.imaginehave.transboot.transboot.entity;

import javax.persistence.*;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transaction extends Audit {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8204157116215472352L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    private BigDecimal amount;
    
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd") 
    private LocalDate date;
    
    @ManyToOne(optional = false)
    @JoinColumns({
        @JoinColumn(
            name = "payer",
            referencedColumnName = "account_name"),
        @JoinColumn(
            name = "payer_id",
            referencedColumnName = "id")
    })
    private Account payer;
    
    @ManyToOne(optional = false)
    @JoinColumns({
        @JoinColumn(
            name = "payee",
            referencedColumnName = "account_name"),
        @JoinColumn(
            name = "payee_id",
            referencedColumnName = "id")
    })
    private Account payee;
    
    
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	
    public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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
       if (obj instanceof Transaction == false)
       {
         return false;
       }
       final Transaction otherObject = (Transaction) obj;

       return new EqualsBuilder()
    		   .append(this.transectUser, otherObject.transectUser)
    		   .append(this.payer, otherObject.payer)
    		   .append(this.payee, otherObject.payee)
    		   .append(this.date, otherObject.date)
    		   .isEquals();
    }
    

}