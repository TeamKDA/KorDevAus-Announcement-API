package org.koreandevelopersaustralia.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Rsvp")
@Table(name = "rsvp", uniqueConstraints={
    @UniqueConstraint(name="index_rsvp", columnNames = {"campaignUid", "emailUid"})
}) 
public class Rsvp {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden=true)
    private Long id;

    @NotBlank
    @Size(min = 1, max = 10)
    @ApiModelProperty(value = "Campaign Unique ID", required = true)
    private String campaignUid;
    
    @NotBlank
    @Size(min = 1, max = 10)
    @ApiModelProperty(value = "Email Unique ID", required = true)
    private String emailUid;
    
    @NotNull
    @ApiModelProperty(value = "Rsvp YN", required = true)
    private boolean isRsvpYn;

    @Transient
    @ApiModelProperty(value = "Member Info", hidden=true)
    private Member member;
    
    @ApiModelProperty(hidden=true)
    private Date created;
    
    @ApiModelProperty(hidden=true)
    private Date updated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCampaignUid() {
		return campaignUid;
	}

	public void setCampaignUid(String campaignUid) {
		this.campaignUid = campaignUid;
	}

	public String getEmailUid() {
		return emailUid;
	}

	public void setEmailUid(String emailUid) {
		this.emailUid = emailUid;
	}

	public boolean isRsvpYn() {
		return isRsvpYn;
	}

	public void setRsvpYn(boolean isRsvpYn) {
		this.isRsvpYn = isRsvpYn;
	}
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campaignUid == null) ? 0 : campaignUid.hashCode());
		result = prime * result + ((emailUid == null) ? 0 : emailUid.hashCode());
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
		Rsvp other = (Rsvp) obj;
		if (campaignUid == null) {
			if (other.campaignUid != null)
				return false;
		} else if (!campaignUid.equals(other.campaignUid))
			return false;
		if (emailUid == null) {
			if (other.emailUid != null)
				return false;
		} else if (!emailUid.equals(other.emailUid))
			return false;
		return true;
	}
}