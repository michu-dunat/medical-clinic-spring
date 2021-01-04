package com.company;

import com.company.model.Notification;
import com.company.services.NotificationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotificationServiceTest {

    @Autowired
    private NotificationService notificationRecordService;

    @Test
    public void findAllTest() {
        var notifications = (List<Notification>) notificationRecordService.findAll();
        System.out.println(notifications.get(0).getDescription());
    }
}
