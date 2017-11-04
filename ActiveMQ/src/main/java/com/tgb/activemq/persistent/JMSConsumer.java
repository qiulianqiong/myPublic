package com.tgb.activemq.persistent;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.tgb.activemq.pub.Listener;

import constants.Constants;

/**
 * 消息消费者-消息订阅者一
 * @author Administrator
 *
 */
public class JMSConsumer {

	private static final String USERNAME=Constants.USERNAME; // 默认的连接用户名
	private static final String PASSWORD=Constants.PASSWORD; // 默认的连接密码
	private static final String BROKEURL=Constants.BROKEURL; // 默认的连接地址
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory; // 连接工厂
		Connection connection = null; // 连接
		Session session; // 会话 接受或者发送消息的线程
		Destination destination; // 消息的目的地
		MessageConsumer messageConsumer; // 消息的消费者
		
		// 实例化连接工厂
		connectionFactory=new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, JMSConsumer.BROKEURL);
				
		try {
			connection=connectionFactory.createConnection();  // 通过连接工厂获取连接
			connection.setClientID("consumer1");
			connection.start(); // 启动连接
			session=connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE); // 创建Session
			// destination=session.createQueue("FirstQueue1");  // 创建连接的消息队列
//			destination=session.createTopic("FirstTopic2");
			Topic topic = session.createTopic("FirstTopic2"); //Topic名称

			messageConsumer=session.createDurableSubscriber(topic,"consumer1"); // 创建消息消费者
			messageConsumer.setMessageListener(new Listener()); // 注册消息监听
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}