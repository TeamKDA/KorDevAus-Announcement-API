package org.koreandevelopersaustralia.app.service;

import java.util.Date;
import java.util.List;

import org.koreandevelopersaustralia.app.model.Rsvp;
import org.koreandevelopersaustralia.app.repository.RsvpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RsvpService {

    @Autowired
    RsvpRepository rsvps;

    public List<Rsvp> getRsvps() {
    	return rsvps.findAll();
    }
    public List<Rsvp> getRsvps(final String campaignUid) {
    	return rsvps.findByCampaignUid(campaignUid);
    }
    public List<Rsvp> getRsvps(final String campaignUid, final String emailUid) {
    	return rsvps.findByCampaignUidAndEmailUid(campaignUid, emailUid);
    }

    public Rsvp upsertRsvp(final Rsvp rsvp) {
    	return _upsertRsvp(rsvp);
    }
    
    public Rsvp upsertRsvp(final String campaignUid, final String emailUid, final Rsvp rsvp) throws Exception {
    	rsvp.setCampaignUid(campaignUid);
    	rsvp.setEmailUid(emailUid);
    	return _upsertRsvp(rsvp);
    }
    
    private Rsvp _upsertRsvp(final Rsvp rsvp) {
    	List<Rsvp> rsvpList = getRsvps(rsvp.getCampaignUid(), rsvp.getEmailUid());
    	Rsvp rsvpObj = null;
    	if (rsvpList != null && rsvpList.size() > 0) {
    		rsvpObj = rsvpList.get(0);
    		rsvpObj.setRsvpYn(rsvp.isRsvpYn());
    		rsvpObj.setUpdated(new Date());
    	} else {
    		rsvpObj = rsvp;
    		rsvpObj.setCreated(new Date());
    	}
    	return rsvps.saveAndFlush(rsvpObj);
    }
}
