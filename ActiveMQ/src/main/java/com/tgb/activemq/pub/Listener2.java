package com.tgb.activemq.pub;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Listener2 implements MessageListener{

	public void onMessage(Message message) {
		TextMessage testMessge = (TextMessage)message;
		try {
			System.out.println("consumer 2 get"+ testMessge.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
