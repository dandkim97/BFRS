package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name="approveMessage", procedureName="approve_message", parameters = {
			@StoredProcedureParameter(type=Integer.class, mode=ParameterMode.IN),
			@StoredProcedureParameter(type=Integer.class, mode=ParameterMode.IN),
			@StoredProcedureParameter(type=String.class, mode=ParameterMode.IN),
			@StoredProcedureParameter(type=String.class, mode=ParameterMode.IN)
	}),
})

@Entity
@Table(name="MESSAGE")
public class Message {
	@Id
	@Column(name="id")
	@SequenceGenerator(name="gen", sequenceName="msg_seq", allocationSize=1)
	@GeneratedValue(generator="gen", strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="asker_id")
	private Integer askerId;
	@Column(name="asked_id")
	private Integer askedId;
	private String status;
	private String type;
	private String quest;
	private String answer;
	
	public Message() {
		super();
	}
	
	public Message(Integer id, Integer askerId, Integer askedId, String status, String type, String quest,
			String answer) {
		super();
		this.id = id;
		this.askerId = askerId;
		this.askedId = askedId;
		this.status = status;
		this.type = type;
		this.quest = quest;
		this.answer = answer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAskerId() {
		return askerId;
	}

	public void setAskerId(Integer askerId) {
		this.askerId = askerId;
	}

	public Integer getAskedId() {
		return askedId;
	}

	public void setAskedId(Integer askedId) {
		this.askedId = askedId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuest() {
		return quest;
	}

	public void setQuest(String quest) {
		this.quest = quest;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((askedId == null) ? 0 : askedId.hashCode());
		result = prime * result + ((askerId == null) ? 0 : askerId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((quest == null) ? 0 : quest.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Message other = (Message) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (askedId == null) {
			if (other.askedId != null)
				return false;
		} else if (!askedId.equals(other.askedId))
			return false;
		if (askerId == null) {
			if (other.askerId != null)
				return false;
		} else if (!askerId.equals(other.askerId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quest == null) {
			if (other.quest != null)
				return false;
		} else if (!quest.equals(other.quest))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", askerId=" + askerId + ", askedId=" + askedId + ", status=" + status + ", type="
				+ type + ", quest=" + quest + ", answer=" + answer + "]";
	}
	
}
