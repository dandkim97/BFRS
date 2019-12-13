package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LOGIN")
public class Login {
	@Id
	@Column(name="id")
	@SequenceGenerator(name="gen", sequenceName="login_seq", allocationSize=1)
	@GeneratedValue(generator="gen", strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column
	private String username;
	private String pswrd;
	@Column(name="first_name")
	private String first;
	@Column(name="last_name")
	private String last;
	@Column(name="is_admin")
	private Integer isAdmin;
	@Column(name="loyalty_status")
	private Integer loyaltyStatus;

	public Login() {
		super();
	}

	public Login(Integer id, String username, String pswrd, String first, String last, Integer isAdmin,
			Integer loyaltyStatus) {
		super();
		this.id = id;
		this.username = username;
		this.pswrd = pswrd;
		this.first = first;
		this.last = last;
		this.isAdmin = isAdmin;
		this.loyaltyStatus = loyaltyStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPswrd() {
		return pswrd;
	}

	public void setPswrd(String pswrd) {
		this.pswrd = pswrd;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Integer getLoyaltyStatus() {
		return loyaltyStatus;
	}

	public void setLoyaltyStatus(Integer loyaltyStatus) {
		this.loyaltyStatus = loyaltyStatus;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPswrd() {
		return pswrd;
	}
	public void setPswrd(String pswrd) {
		this.pswrd = pswrd;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public Integer getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Integer getLoyaltyStatus() {
		return loyaltyStatus;
	}
	public void setLoyaltyStatus(Integer loyaltyStatus) {
		this.loyaltyStatus = loyaltyStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isAdmin == null) ? 0 : isAdmin.hashCode());
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		result = prime * result + ((loyaltyStatus == null) ? 0 : loyaltyStatus.hashCode());
		result = prime * result + ((pswrd == null) ? 0 : pswrd.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
  }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isAdmin == null) {
			if (other.isAdmin != null)
				return false;
		} else if (!isAdmin.equals(other.isAdmin))
			return false;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		if (loyaltyStatus == null) {
			if (other.loyaltyStatus != null)
				return false;
		} else if (!loyaltyStatus.equals(other.loyaltyStatus))
			return false;
		if (pswrd == null) {
			if (other.pswrd != null)
				return false;
		} else if (!pswrd.equals(other.pswrd))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", username=" + username + ", pswrd=" + pswrd + ", first=" + first + ", last=" + last
				+ ", isAdmin=" + isAdmin + ", loyaltyStatus=" + loyaltyStatus + "]";
	}
	
}
