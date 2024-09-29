package com.hospital.adapt.config;


public class RabbitMQConfig {

    public static final String DEFAULT_DIRECT_EXCHANGE = "amq.direct";
    //public static final String DEFAULT_FANOUT_EXCHANGE = "amq.fanout";
    //public static final String DEFAULT_TOPIC_EXCHANGE = "amq.topic";

    //public static final String SRV_ACK_QUEUE = "srv_ack_receive";
    //public static final String SRV_ACK_EXCHANGE = "srv_ack_exchange";
    public static final String SRV_ACK_ROUTINGKEY = "srv_ack_receive";
}
