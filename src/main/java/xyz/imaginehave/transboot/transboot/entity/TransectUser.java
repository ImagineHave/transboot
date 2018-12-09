package xyz.imaginehave.transboot.transboot.entity;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
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

	@Column(name = "key")
	private String key;

}

