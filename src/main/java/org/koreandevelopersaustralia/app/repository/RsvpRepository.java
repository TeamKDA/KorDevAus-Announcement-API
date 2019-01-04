package org.koreandevelopersaustralia.app.repository;
import java.util.List;

import org.koreandevelopersaustralia.app.model.Rsvp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 */
@Repository
public interface RsvpRepository extends JpaRepository<Rsvp, Long> {
	
	List<Rsvp> findAll();
	List<Rsvp> findByCampaignUid(String campaignUid);
	List<Rsvp> findByEmailUid(String emailUid);
	List<Rsvp> findByCampaignUidAndEmailUid(String campaignUid, String emailUid);
	
	Rsvp saveAndFlush(Rsvp rsvp);
}