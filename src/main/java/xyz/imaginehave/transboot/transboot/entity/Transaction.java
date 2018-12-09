package xyz.imaginehave.transboot.transboot.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Transaction extends Audit {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8204157116215472352L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@Column(name = "amount")
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

}