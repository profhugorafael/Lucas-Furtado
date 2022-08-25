package com.lucas.mqtt.publishers;

import java.util.Random;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class RoomPublisher {

	private static MqttClient airMqttClient ;

	public static void main(String[] args) {

		String topic1 = "/floor/room/temperature";
		String topic2 = "/floor/room/humidity";
		
		
		String temperatureContent = generateTemperature();
		String humidtyContent = generateHumidity();

		String clientId = "Air Publisher";
		String broker = "tcp://localhost:1883";
		
		MemoryPersistence persistence = new MemoryPersistence();

		try {

			airMqttClient = new MqttClient(broker, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);

			connOpts.setKeepAliveInterval(160);
			
			System.out.println("Connecting to broker: " + broker);
			airMqttClient.connect(connOpts);
			System.out.println("Connected");


			// messages
			publishMessage(topic1, temperatureContent, 2, false);
			publishMessage(topic2, humidtyContent, 1, false);

			//disconnecting   		   
			airMqttClient.disconnect();

			System.out.println("Disconnected from the air system");
			
			airMqttClient.close();
	        
			System.exit(0);

		} catch (MqttException me) {
			System.out.println("reason " + me.getReasonCode());
			System.out.println("msg " + me.getMessage());
			System.out.println("loc-msg " + me.getLocalizedMessage());
			System.out.println("cause " + me.getCause());
			System.out.println("exception " + me);
			me.printStackTrace();
		}

	}

	private static void publishMessage(String topic, String payload, int qos, boolean retained) {

		System.out.println("Publishing message: " + payload + " on topic "+ topic );            

		MqttMessage message = new MqttMessage(payload.getBytes());
		message.setRetained(retained);
		message.setQos(qos);     

		try {

			airMqttClient.publish(topic, message);

		} catch (MqttException mqttException) {
			System.err.println("reason " + mqttException.getReasonCode());
			System.err.println("message " + mqttException.getMessage());
			System.err.println("loc-message " + mqttException.getLocalizedMessage());
			System.err.println("cause " + mqttException.getCause());
			System.err.println("exception " + mqttException);
			mqttException.printStackTrace();
		}

		System.out.println("Message published");


	}
	
	private static String generateTemperature() {
		int[] temperatures = {18, 22, 23, 26, 28, 30, 31, 35, 37};
		Random random = new Random();
		int pos = random.nextInt(9);
		return temperatures[pos] + "ºC";
	}
	
	private static String generateHumidity() {
		int[] temperatures = {8, 10, 12, 13, 18, 15, 20, 25, 27};
		Random random = new Random();
		int pos = random.nextInt(9);
		return temperatures[pos] + "%";
	}

}

