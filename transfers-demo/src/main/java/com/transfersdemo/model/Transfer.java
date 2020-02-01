package com.transfersdemo.model;

import java.math.BigDecimal;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.CreditCardNumber;

@Entity
@Table(name = "transfers")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Transfer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transfer_id_sequence")
	@SequenceGenerator(name = "transfer_id_sequence", sequenceName = "transfer_id_sequence", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;

	@Column(name = "amount", nullable = false)
	private BigDecimal amount;

	public long getId() {
		return id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String from) {
		this.fromAccount = from;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String to) {
		this.toAccount = to;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "from_account", nullable = false)
	private String fromAccount;

	@Column(name = "to_account", nullable = false)
	private String toAccount;

	@Column(name = "comment")
	private String comment;

	@CreditCardNumber
	@Column(name = "pan")
	private String pan;
	
	@CreditCardNumber
	@Column(name = "pan2")
	private String pan2;

	public String getPan2() {
		return pan2;
	}

	public void setPan2(String pan2) {
		this.pan2 = pan2;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

}
