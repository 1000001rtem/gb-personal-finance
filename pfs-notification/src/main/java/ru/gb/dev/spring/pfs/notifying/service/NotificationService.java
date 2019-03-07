package ru.gb.dev.spring.pfs.notifying.service;

import ru.gb.dev.spring.pfs.notifying.exception.ErrorDatabase;
import ru.gb.dev.spring.pfs.notifying.model.Notification;

import java.util.Optional;

public interface NotificationService {

    Notification save(Notification notification) throws ErrorDatabase;

    Optional<Notification> findById(String  id);

    Iterable<Notification> findAll();

    Iterable<Notification> findIsActive();

    Notification update(Notification notification) throws ErrorDatabase;

    void deleteById(String id) throws ErrorDatabase;

    void delete(Notification notification) throws ErrorDatabase;

}
