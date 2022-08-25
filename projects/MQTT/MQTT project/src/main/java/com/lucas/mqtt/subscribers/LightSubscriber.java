package com.lucas.mqtt.subscribers;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class LightSubscriber implements MqttCallback {

    public static void main(String[] args) {

        String broker = "tcp://localhost:1883";
        String clientId = "Subscriber";
        
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
         
            //if cleanSession is true before connecting the client, 
            //then all pending publication deliveries for the client are removed 
            //when the client connects.
            connOpts.setCleanSession(true);
            
            sampleClient.setCallback(new LightSubscriber());
            
            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            
            //subscribe to topic
            sampleClient.subscribe("/site/#");
            
        } catch (MqttException mqttException) {
            System.out.println("reason " + mqttException.getReasonCode());
            System.out.println("msg " + mqttException.getMessage());
            System.out.println("loc " + mqttException.getLocalizedMessage());
            System.out.println("cause " + mqttException.getCause());
            System.out.println("excep " + mqttException);
            mqttException.printStackTrace();
        }
    }

	@Override
	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
	}
}
