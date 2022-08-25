package com.lucas.mqtt;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MQTTSubscriberLight {

    public static void main(String[] args) {

        String broker = "tcp://localhost:1883";
        String clientId = "Subscriber";
        
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
         

            connOpts.setCleanSession(true);
            
            sampleClient.setCallback((MqttCallback) new MQTTSubscriberLight());
            System.out.println("Connecting to broker: " + broker);
            
            sampleClient.connect(connOpts);
            System.out.println("Connected");

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
}
