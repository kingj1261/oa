package com.wantai.oa.test.message;

import com.wantai.oa.biz.shared.request.PageRequest;
import com.wantai.oa.common.dal.mappings.dos.message.MessageDo;
import com.wantai.oa.common.dal.mappings.dos.message.RemindDo;
import com.wantai.oa.common.dal.mappings.dos.message.SuperviseDo;
import com.wantai.oa.common.lang.enums.MessageReadStatusEnum;
import com.wantai.oa.common.lang.enums.MessageTypeEnum;
import com.wantai.oa.common.lang.enums.RemindTypeEnum;
import com.wantai.oa.message.MessageService;
import com.wantai.oa.message.request.MessageRequest;
import com.wantai.oa.message.request.RemindRequest;
import com.wantai.oa.message.request.SuperviseRequest;
import com.wantai.oa.test.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

/**
 * @author Sharpe on 2016-01-16.
 */
public class MessageServiceTest extends BaseTest {

    @Autowired
    private MessageService messageService;

    @Autowired
    private JdbcTemplate   jdbcTemplate;

    private MessageDo      messageDo;

    private SuperviseDo    superviseDo;

    private RemindDo       remindDo;

    @Before
    public void setUp() throws Exception {
        buildSupervise();
        buildRemind();
    }

    //    @Test
    @After
    public void after() throws Exception {
        jdbcTemplate
            .update(
                "delete os from oa_supervise os where exists(select 1 from oa_message om where om.customer_id=? and om.customer_name=? and om.id=os.message_id)",
                "99999", "sharpe");

        jdbcTemplate
            .update(
                "delete ore from oa_remind ore where exists(select 1 from oa_message om where om.customer_id=? and om.customer_name=? and om.id=ore.message_id)",
                "99999", "sharpe");

        jdbcTemplate.update(
            "delete om from oa_message om where om.customer_id=? and om.customer_name=?", "99999",
            "sharpe");

    }

    private void buildMessage() {
        this.messageDo = new MessageDo();

        messageDo.setCompanyCode("99999999999");
        messageDo.setCompanyId("1");

        messageDo.setCustomerId("99999");
        messageDo.setCustomerName("sharpe");

        messageDo.setBizItem("200000000000");
        messageDo.setBizEvent("20000000");
        messageDo.setEndTime(new Date());
        messageDo.setReadStatus(MessageReadStatusEnum.UNREAD.getCode());
        messageDo.setMessageType(MessageTypeEnum.BUSINESS.getCode());
        messageDo.setMessageBody("this is message body");
        messageDo.setOperator("admin");
        messageDo.setLastModifiedOperator("admin");
    }

    private void buildSupervise() {
        superviseDo = new SuperviseDo();
        buildMessage();

        superviseDo.setMessageDo(messageDo);
        superviseDo.setOutLimitDays(3);

    }

    private void buildRemind() {
        remindDo = new RemindDo();
        buildMessage();

        remindDo.setMessageDo(messageDo);
        remindDo.setRemindType(RemindTypeEnum.BUSINESS.getCode());

    }

    @Test
    public void testAddSupervise() throws Exception {
        messageService.addSupervise(superviseDo);
    }

    @Test
    public void testAddRemind() throws Exception {
        messageService.addRemind(remindDo);
    }

    @Test
    public void testQuerySupervise() throws Exception {
        testAddSupervise();
        SuperviseRequest messageReques = new SuperviseRequest();

        //messageReques.setCompanyCode("99999999999");
        //messageReques.setCompanyId("1");

        //messageReques.setCustomerId("99999");
        messageReques.setCustomerName("sharpe");

        PageRequest pageRequest = new PageRequest(1, 20);

        List<SuperviseDo> superviseDos = messageService.querySupervise(messageReques, pageRequest);
        assertTrue(superviseDos.size() == 1);
    }

    @Test
    public void testQueryRemind() throws Exception {
        testAddRemind();

        RemindRequest messageReques = new RemindRequest();

        //        messageReques.setCompanyCode("99999999999");
        //        messageReques.setCompanyId("1");
        //
        //        messageReques.setCustomerId("99999");
        //        messageReques.setCustomerName("sharpe");

        PageRequest pageRequest = new PageRequest(1, 20);
        List<RemindDo> remindDos = messageService.queryRemind(messageReques, pageRequest);
        assertTrue(remindDos.size() == 1);
    }

    @Test
    public void testQueryMessage() throws Exception {
        testAddRemind();
        testAddSupervise();

        MessageRequest messageReques = new MessageRequest();

        //        messageReques.setCompanyCode("99999999999");
        //        messageReques.setCompanyId("1");
        //
        //        messageReques.setCustomerId("99999");
        //        messageReques.setCustomerName("sharpe");

        PageRequest pageRequest = new PageRequest(1, 20);
        List<MessageDo> messageDos = messageService.queryMessage(messageReques, pageRequest);
        assertTrue(messageDos.size() == 2);
    }

}