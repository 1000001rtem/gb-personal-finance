package ru.gb.dev.spring.pfs.accounting.util;

import org.springframework.stereotype.Component;

@Component
public class UserContext {

    public static final String CORRELATION_ID = "pfs-correlation-id";
    public static final String AUTH_TOKEN = "Authorization";
    public static final String USER_ID = "pfs-user-id";

    private static final ThreadLocal<String> correlationId = new ThreadLocal<>();
    private static final ThreadLocal<String> authToken = new ThreadLocal<>();
    private static final ThreadLocal<String> userId = new ThreadLocal<>();

    public static String getCorrelationId() {
        return correlationId.get();
    }

    public static String getAuthToken() {
        return authToken.get();
    }

    public static String getUserId() {
        return userId.get();
    }

    public static void setCorrelationId(String cid) {
        correlationId.set(cid);
    }

    public static void setAuthToken(String aToken) {
        authToken.set(aToken);
    }

    public static void setUserId(String aUser) {
        userId.set(aUser);
    }
}
