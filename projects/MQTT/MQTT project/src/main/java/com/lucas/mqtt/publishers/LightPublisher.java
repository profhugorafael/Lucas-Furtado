package com.lucas.mqtt.publishers;

import java.util.Random;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class LightPublisher {

	private static MqttClient lightMqttClient ;

	public static void main(String[] args) {

		String topic1 = "/floor/light/ID";
		String topic2 = "/floor/light/location";
		
		String idContent = generateID();
		String locationContent = generateLocation();

		String broker = "tcp://localhost:1883";
		String clientId = "Publisher";

		MemoryPersistence persistence = new MemoryPersistence();

		try {

			lightMqttClient = new MqttClient(broker, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();

			//if cleanSession is true before connecting the client, 
			//then all pending publication deliveries for the client are removed 
			//when the client connects.
			connOpts.setCleanSession(true);

			connOpts.setKeepAliveInterval(180);
			
			//connOpts.setUserName("");
			//connOpts.setPassword("");
			
			//connecting
			System.out.println("Connecting to broker: " + broker);
			lightMqttClient.connect(connOpts);
			System.out.println("Connected");


			// messages
			publishMessage(topic1, idContent, 2, false);
			publishMessage(topic2, locationContent, 1, false);

			// disconnecting        		   
			lightMqttClient.disconnect();

			System.out.println("Disconnected");
			
			lightMqttClient.close();
	        
			System.exit(0);

		} catch (MqttException mqttException) {
			System.out.println("reason " + mqttException.getReasonCode());
			System.out.println("msg " + mqttException.getMessage());
			System.out.println("loc-msg " + mqttException.getLocalizedMessage());
			System.out.println("cause " + mqttException.getCause());
			System.out.println("exception " + mqttException);
			mqttException.printStackTrace();
		}

	}

	private static void publishMessage(String topic, String payload, int qos, boolean retained) {

		System.out.println("Publishing message: " + payload + " on topic "+ topic );            

		MqttMessage message = new MqttMessage(payload.getBytes());
		message.setRetained(retained);
		message.setQos(qos);     

		try {

			lightMqttClient.publish(topic, message);

		} catch (MqttException mqqtException) {
			System.err.println("reason " + mqqtException.getReasonCode());
			System.err.println("msg " + mqqtException.getMessage());
			System.err.println("loc-msg " + mqqtException.getLocalizedMessage());
			System.err.println("cause " + mqqtException.getCause());
			System.err.println("exception " + mqqtException);
			mqqtException.printStackTrace();
		}

		System.out.println("Message published");

	}
	
	private static String generateID() {
		Random random = new Random();
		
		if(random.nextInt(10)%2 == 0) {
			return "ON";
		} else {			
			return "OFF";
		}
		
	}

	private static String generateLocation() {
		Random random = new Random();
		
		if(random.nextInt(10)%2 == 0) {
			return "OPEN";
		} else {			
			return "CLOSE";
		}
	}
	
}

