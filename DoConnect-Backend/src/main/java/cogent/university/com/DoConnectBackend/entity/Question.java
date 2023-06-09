package cogent.university.com.DoConnectBackend.entity;

import java.sql.Blob;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "question_tbl")
public class Question {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description_question;

	@Lob
	private String image_src;

	private String datetime;
	private String status;
	private String topic;
	private String title;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@JsonIgnore
	private List<Answer> answers;
	
	//@OneToOne
	private String qcreated_by;
	
	//@OneToOne
	private String qapproved_by;

	public Question() {
	}

	public Question(String description_question, String image_src, String datetime, String status, String topic, String title) {
		this.description_question = description_question;
		this.image_src = image_src;
		this.datetime = datetime;
		this.status = status;
		this.topic = topic;
		this.title = title;
	}

	public Question(String description_question, String image_src, String datetime, String status, String topic, String title, List<Answer> answers, String qcreated_by, String qapproved_by) {
		this.description_question = description_question;
		this.image_src = image_src;
		this.datetime = datetime;
		this.status = status;
		this.topic = topic;
		this.title = title;
		this.answers = answers;
		this.qcreated_by = qcreated_by;
		this.qapproved_by = qapproved_by;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription_question() {
		return description_question;
	}

	public void setDescription_question(String description_question) {
		this.description_question = description_question;
	}

	public String getImage_src() {
		return image_src;
	}

	public void setImage_src(String image_src) {
		this.image_src = image_src;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public String getQcreated_by() {
		return qcreated_by;
	}

	public void setQcreated_by(String qcreated_by) {
		this.qcreated_by = qcreated_by;
	}

	public String getQapproved_by() {
		return qapproved_by;
	}

	public void setQapproved_by(String qapproved_by) {
		this.qapproved_by = qapproved_by;
	}
}


