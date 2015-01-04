package com.elkammar.thattodo.services.notifications;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Utility class for notifications, should contain all the details
 * of texting or emailing functionalities.
 * 
 * @author elkammar
 *
 */
@Component
public class NotificationUtil {

	public static final String ACCOUNT_SID = "ACdecde1fbac7046b671cf2ded8ee43089";
	public static final String AUTH_TOKEN = "3aab4329ac9dc42f344049123bf797a3";

	/**
	 * Does nothing, just for clarification.
	 */
	public void sendEmail(List<String> recipients, String body){
		
	}
	
	public void sendSms(String recipient, String body) {
		
	}
}

/**
 * Twilio testing
 */
//TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
//
//// Build the parameters
//List<NameValuePair> params = new ArrayList<NameValuePair>();
//params.add(new BasicNameValuePair("To", "+16518081900"));
//params.add(new BasicNameValuePair("From", "+17633163596"));
//params.add(new BasicNameValuePair("Body", "test"));
//
//MessageFactory messageFactory = client.getAccount().getMessageFactory();
//Message message = messageFactory.create(params);
//System.out.println(message.getSid());
