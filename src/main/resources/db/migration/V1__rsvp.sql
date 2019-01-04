CREATE TABLE IF NOT EXISTS rsvp (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  campaign_uid VARCHAR(10) NOT NULL,
  email_uid VARCHAR(10) NOT NULL,
  is_rsvp_yn TINYINT(1) DEFAULT 0,
  created DATETIME,
  updated DATETIME,
  PRIMARY KEY (id),
  UNIQUE KEY uk_rsvp (campaign_uid, email_uid)
);