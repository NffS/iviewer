package test;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="HR_mark")
public class HR_mark {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="hr_mark_id")
	private Integer hr_mark_id;
	
	@Column(name="hr_id")
	private Integer hr_id;
	
	@Column(name="form_id")
	private Integer form_id;
	
	@Column(name="motivation")
	private Integer motivation;
	
	@Column(name="english")
	private Integer english;
	
	@Column(name="general_mark")
	private String general_mark;
	
	/*
	@OneToMany(mappedBy="HR_mark", cascade=CascadeType.ALL)
	private Set<User> users;
	
	@OneToOne
    @JoinColumn(name="form_id")
    private Form form;
	*/
	
	
	public Integer getHR_mark_id() {
		return hr_mark_id;
	}
	
	public void setHR_mark_id(Integer hr_mark_id) {
		this.hr_mark_id = hr_mark_id;
	}
			
	public Integer getHr_id() {
		return hr_id;
	}
	
	public void setHr_id(Integer hr_id) {
		this.hr_id = hr_id;
	}

	public Integer getForm_id() {
		return form_id;
	}
	
	public void setForm_id(Integer form_id) {
		this.form_id = form_id;
	}
	
	public Integer getMotivation() {
		return motivation;
	}
	
	public void setMotivation(Integer motivation) {
		this.motivation = motivation;
	}
	
	public Integer getEnglish() {
		return english;
	}
	
	public void setEnglish(Integer english) {
		this.english = english;
	}
	
	public String getGeneral_mark() {
		return general_mark;
	}
	
	public void setgeneral_mark(String general_mark) {
		this.general_mark = general_mark;
	}
	
}