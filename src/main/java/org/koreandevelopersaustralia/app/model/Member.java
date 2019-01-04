package org.koreandevelopersaustralia.app.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Member")
public class Member {

	@ApiModelProperty(value = "id", hidden=true)
	@JsonView(Views.Admin.class)
	private String id;

	@ApiModelProperty(value = "unique email id", required = true)
	private String emailUid;
	
	@ApiModelProperty(value = "email", required = true)
	private String email;
	
	@ApiModelProperty(value = "first name")
	@JsonView(Views.Normal.class)
	private String firstName;
	
	@ApiModelProperty(value = "last name")
	@JsonView(Views.Normal.class)
	private String lastName;
	
	@ApiModelProperty(value = "korean name")
	@JsonView(Views.Normal.class)
	private String korName;

	@ApiModelProperty(value = "status")
	@JsonView(Views.Normal.class)
	private String status;
	
	@JsonGetter("emailUid")
	public String getEmailUid() {
		return emailUid;
	}

	@JsonSetter("unique_email_id")
	public void setEmailUid(String emailUid) {
		this.emailUid = emailUid;
	}

	@JsonGetter("email")
	@JsonView(Views.Normal.class)
	public String getEmail() {
		return email;
	}

	@JsonSetter("email_address")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonGetter("firstName")
	public String getFirstName() {
		return firstName;
	}

	@JsonGetter("lastName")
	public String getLastName() {
		return lastName;
	}
	
	@JsonGetter("korName")
	public String getKorName() {
		return korName;
	}

	@JsonProperty("merge_fields")
	public void setMergeFields(Map<String, String> mergeFields) {
		this.firstName = mergeFields.get("FNAME");
		this.lastName = mergeFields.get("LNAME");
		this.korName = mergeFields.get("MMERGE5");
	}
	
}
