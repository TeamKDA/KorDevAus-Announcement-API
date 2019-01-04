package org.koreandevelopersaustralia.app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Members")
public class Members {
	
	@ApiModelProperty(value = "Member list", required = true)
	@JsonProperty("members")
	@JsonView(Views.Normal.class)
	private List<Member> members;

	@ApiModelProperty(value = "total count")
	@JsonView(Views.Normal.class)
	private int total;

	public int getTotal() {
		return members.size();
	}
	
	public List<Member> getMembers() {
		return members;
	}
	
}
