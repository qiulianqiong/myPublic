package com.tgb.activemq.persistent;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.tgb.activemq.pub.Listener2;

import constants.Constants;

/**
 * ��Ϣ������-��Ϣ�����߶�
 * @author Administrator
 *
 */
public class JMSConsumer2 {

	private static final String USERNAME=Constants.USERNAME; // Ĭ�ϵ������û���
	private static final String PASSWORD=Constants.PASSWORD; // Ĭ�ϵ���������
	private static final String BROKEURL=Constants.BROKEURL; // Ĭ�ϵ����ӵ�ַ
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory; // ���ӹ���
		Connection connection = null; // ����
		Session session; // �Ự ���ܻ��߷�����Ϣ���߳�
		Destination destination; // ��Ϣ��Ŀ�ĵ�
		MessageConsumer messageConsumer; // ��Ϣ��������
		
		// ʵ�������ӹ���
		connectionFactory=new ActiveMQConnectionFactory(JMSConsumer2.USERNAME, JMSConsumer2.PASSWORD, JMSConsumer2.BROKEURL);
				
		try {
			connection=connectionFactory.createConnection();  // ͨ�����ӹ�����ȡ����
			connection.setClientID("consumer2");
			connection.start(); // ��������
			session=connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE); // ����Session
			// destination=session.createQueue("FirstQueue1");  // �������ӵ���Ϣ����
			Topic topic =session.createTopic("FirstTopic2");
			messageConsumer=session.createDurableSubscriber(topic,"consumer2"); // ������Ϣ������
			messageConsumer.setMessageListener(new Listener2()); // ע����Ϣ����
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}