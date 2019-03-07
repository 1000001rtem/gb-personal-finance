package ru.gb.dev.spring.pfs.notifying.dto.util;

import org.modelmapper.ModelMapper;
import ru.gb.dev.spring.pfs.notifying.dto.NotificationAbstractDTO;
import ru.gb.dev.spring.pfs.notifying.model.Notification;

/**
 * @author S.Kogut on 2019-02-24
 */
public class ConvertUtil {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <D> D convertNotificationToDto(Notification notification,
                                                           Class<D> notificationDto){
        return modelMapper
                .map(notification, notificationDto);

    }

    public static Notification convertDtoToNotification(NotificationAbstractDTO notifucationDto){

        return modelMapper
                .map(notifucationDto, Notification.class);

    }

    public static <D> D converDtoToDto(NotificationAbstractDTO notificationDtoIn,
                                       Class<D> notificationDtoOut){
        return modelMapper
                .map(notificationDtoIn, notificationDtoOut);
    }
}
