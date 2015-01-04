package com.elkammar.thattodo.services.notifications;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;

import com.elkammar.thattodo.exceptions.ThatException;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;

/**
 * Utility class for notifications, should contain all the details
 * of texting or emailing functionalities.
 * 
 * @author elkammar
 *
 */
@Component
public class NotificationUtil {

	private static final String ACCOUNT_SID = "ACdecde1fbac7046b671cf2ded8ee43089";
	private static final String AUTH_TOKEN = "3aab4329ac9dc42f344049123bf797a3";
	private static final String SENDER = "+17633163596";
	
	private TwilioRestClient client;
	
	/**
	 * Does nothing, just for clarification.
	 */
	public void sendEmail(List<String> recipients, String body){
		//do nothing
	}
	
	/**
	 * Sends SMS using Twilio.
	 * 
	 * @param recipient phone number to send message to.
	 * @param body body of the text message
	 * @throws ThatException
	 */
	public void sendSms(String recipient, String body) throws ThatException {
		client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		// Build the parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("To", recipient));
		params.add(new BasicNameValuePair("From", SENDER));
		params.add(new BasicNameValuePair("Body", body));
		
		MessageFactory messageFactory = client.getAccount().getMessageFactory();
		try {
			messageFactory.create(params);
		} catch (TwilioRestException e) {
			throw new ThatException("ERROR: Failed to send message to "+recipient);
		}
	}
	
}
