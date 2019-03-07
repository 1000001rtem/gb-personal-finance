package ru.gb.dev.spring.pfs.notifying;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gb.dev.spring.pfs.notifying.dto.NotificationDTOCreate;
import ru.gb.dev.spring.pfs.notifying.dto.NotificationDTODelete;
import ru.gb.dev.spring.pfs.notifying.dto.NotificationDTOUpdate;
import ru.gb.dev.spring.pfs.notifying.dto.util.ConvertUtil;
import ru.gb.dev.spring.pfs.notifying.dto.view.NotificationDTOView;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author S.Kogut on 2019-02-24
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PfsNotificationRestServiceTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private NotificationDTOCreate notificationDtoCreate = null;

    private final String HOST_NAME = "http://localhost:10151/api/notify";

    @Before
    public void initObjects(){
        notificationDtoCreate  = new NotificationDTOCreate(true,"1", LocalDateTime.now(),
                "Test title", "Test body");
    }

    @Test
    @WithMockUser(username = "vasya.pupkin",roles={"USER", "ADMIN"})
    public void testRestService(){
        ResponseEntity<NotificationDTOView> entity = testRestTemplate.postForEntity(HOST_NAME + "/createNotify",
                notificationDtoCreate, NotificationDTOView.class);

        Assert.assertEquals(entity.getStatusCodeValue(), 201);
        Assert.assertNotNull(entity.getBody().getId());
        Assert.assertEquals(entity.getBody().getBody(), notificationDtoCreate.getBody());
        Assert.assertEquals(entity.getBody().getTitle(), notificationDtoCreate.getTitle());
        Assert.assertEquals(entity.getBody().getUserId(), notificationDtoCreate.getUserId());
        Assert.assertEquals(entity.getBody().getDateTime(), notificationDtoCreate.getDateTime());

        NotificationDTOUpdate notificationDtoUpdate = ConvertUtil.converDtoToDto(entity.getBody(), NotificationDTOUpdate.class);
        Assert.assertEquals(entity.getBody().getId(), notificationDtoUpdate.getId());
        Assert.assertEquals(entity.getBody().getTitle(), notificationDtoUpdate.getTitle());
        Assert.assertEquals(entity.getBody().getIsActive(), notificationDtoUpdate.getIsActive());
        Assert.assertEquals(entity.getBody().getBody(), notificationDtoUpdate.getBody());

        notificationDtoUpdate.setIsActive(false);

        testRestTemplate.put(HOST_NAME + "/updateNotify", notificationDtoUpdate);

        String urlId  = HOST_NAME + "/" + notificationDtoUpdate.getId();

        ResponseEntity<NotificationDTOView> entityGetId = testRestTemplate.getForEntity(urlId,
                                                             NotificationDTOView.class);
        Assert.assertEquals(entityGetId.getStatusCodeValue(),  200);
        Assert.assertFalse(entityGetId.getBody().getIsActive());

        ResponseEntity<List<NotificationDTOView>>  listResponseEntity =
                testRestTemplate.exchange(HOST_NAME + "/getAllNotify",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<NotificationDTOView>>() {});
        Assert.assertEquals(listResponseEntity.getStatusCodeValue(), 200);
        Assert.assertTrue(listResponseEntity.getBody().size() > 0);

        testRestTemplate.delete(urlId);

        entityGetId = testRestTemplate.getForEntity(urlId,
                NotificationDTOView.class);

        Assert.assertEquals(entityGetId.getStatusCodeValue(), 500);

        entity = testRestTemplate.postForEntity(HOST_NAME + "/createNotify",
                notificationDtoCreate, NotificationDTOView.class);

        Assert.assertEquals(entity.getStatusCodeValue(), 201);
        Assert.assertNotNull(entity.getBody().getId());

        urlId = HOST_NAME + "/" + entity.getBody().getId();

        testRestTemplate.delete(urlId, ConvertUtil.converDtoToDto(entity.getBody(), NotificationDTODelete.class));

        entityGetId = testRestTemplate.getForEntity(urlId,
                NotificationDTOView.class);

        Assert.assertEquals(entityGetId.getStatusCodeValue(),  500);
    }
}
