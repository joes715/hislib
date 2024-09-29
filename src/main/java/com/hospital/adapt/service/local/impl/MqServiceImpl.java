package com.hospital.adapt.service.local.impl;

import com.alibaba.fastjson.JSON;
import com.hospital.adapt.constant.Statics;
import com.hospital.adapt.service.common.impl.BaseServiceImpl;
import com.hospital.adapt.mapper.local.LbnPatientMapper;
import com.hospital.adapt.config.RabbitMQConfig;
import com.hospital.adapt.model.common.MqMessageModel;
import com.hospital.adapt.service.local.MqService;
import com.hospital.adapt.utils.SFU;
import com.hospital.adapt.utils.Str2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MqServiceImpl extends BaseServiceImpl implements MqService {
    @Resource
    private LbnPatientMapper lbnPatientMapper = null;

    @Resource
    private RabbitTemplate rabbitTemplate = null;
    private static Logger log = LoggerFactory.getLogger(MqServiceImpl.class);

    private void convertAndSend(String exchange, String routingKey, Object message, CorrelationData correlationData) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message, correlationData);
    }

    @Override
    public void refreshData(String adm_num) {
        if (Str2.notNull(adm_num)) {
            String bed_dev_code = lbnPatientMapper.queryBedDevicesnByAdn(adm_num);
            String room_dev_code = lbnPatientMapper.queryRoomDevicesnByAdn(adm_num);
            sendMsg(bed_dev_code);
            sendMsg(room_dev_code);
        } else {
            log.warn("Info empty");
        }
    }

    private void sendMsg(String dev_code) {
        if (Str2.notNull(dev_code)) {
            MqMessageModel msgModel = new MqMessageModel();
            msgModel.setAct("refresh_data");
            msgModel.setAttr("patient");

            String msgId = Long.toString(SFU.nextId(Statics.DATACENTER_ID, Statics.MACHINE_ID));
            Message message = MessageBuilder.withBody(JSON.toJSONString(msgModel).getBytes()).build();
            message.getMessageProperties().setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN);
            message.getMessageProperties().setMessageId(msgId);
            message.getMessageProperties().setReplyTo(RabbitMQConfig.SRV_ACK_ROUTINGKEY);
            message.getMessageProperties().setExpiration(Statics.MQ_MSG_EXPIRATION);

            CorrelationData cd = new CorrelationData(msgId);

            convertAndSend(RabbitMQConfig.DEFAULT_DIRECT_EXCHANGE, dev_code, message, cd);
        } else {
            log.warn("Ref data exception？");
        }
    }
}
