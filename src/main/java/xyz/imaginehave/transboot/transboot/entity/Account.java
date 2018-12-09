package xyz.imaginehave.transboot.transboot.entity;

import javax.persistence.*;

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
	
    private String accountName;
    
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd") 
    private LocalDate openedDate;
    
    @ManyToOne
    @JoinColumns({
        @JoinColumn(
            name = "user_name",
            referencedColumnName = "user_name"),
        @JoinColumn(
            name = "emails",
            referencedColumnName = "email")
    })
    private TransectUser user;

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

	public TransectUser getUser() {
		return user;
	}

	public void setUser(TransectUser user) {
		this.user = user;
	}

}