package xyz.imaginehave.transboot.transboot.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
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

}