package xyz.imaginehave.transboot.transboot.entity;

import javax.persistence.*;

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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	
    @ManyToOne(optional = false)
    @JoinColumns({
        @JoinColumn(
            name = "account_name",
            referencedColumnName = "account_name", 
            insertable=false, 
            updatable=false)
    })
    private Account payer;
    
    @ManyToOne(optional = false)
    @JoinColumns({
        @JoinColumn(
                name = "account_name",
                referencedColumnName = "account_name", 
                insertable=false, 
                updatable=false)
    })
    private Account payee;
    
    private BigDecimal amount;
    
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd") 
    private LocalDate date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}