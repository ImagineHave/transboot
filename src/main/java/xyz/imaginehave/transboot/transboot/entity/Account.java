package xyz.imaginehave.transboot.transboot.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Account extends Audit {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8085310684289086942L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
    private String accountName;
    
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd") 
    private LocalDate openedDate;
    
    
    private ArrayList<Transaction> transactions;
    
    
    private String user;
    


}