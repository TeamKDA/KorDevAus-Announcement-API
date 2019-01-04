package org.koreandevelopersaustralia.app.strategry;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.koreandevelopersaustralia.app.model.Members;
import org.koreandevelopersaustralia.app.model.Rsvp;
import org.springframework.stereotype.Component;

@Component
public class MemberRsvpAggregationStrategy implements AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }
        
        Rsvp rsvp = oldExchange.getIn().getBody(Rsvp.class);
        Members members = newExchange.getIn().getBody(Members.class);
        if (members.getTotal() > 0 && 
        		rsvp.getEmailUid().equals(members.getMembers().get(0).getEmailUid())) {
        	rsvp.setMember(members.getMembers().get(0));	
        	oldExchange.getIn().setBody(rsvp);
        }
        return oldExchange;
    }

}