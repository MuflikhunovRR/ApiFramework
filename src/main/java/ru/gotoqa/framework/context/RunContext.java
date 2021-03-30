package ru.gotoqa.framework.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Thread.currentThread;

/**
 * Context class for object storage
 */
public enum RunContext {
    RUN_CONTEXT;

    private final Map<String, Object> context = new ConcurrentHashMap<>();

    private static final String NO_KEY_MESSAGE = "Object with key %s doesn't exist!";

    RunContext() {
    }

    public void deleteKey(String key) {
        key = wrapKey(key);
        context.remove(key);
    }

    public <T> void put(String key, T object) {
        key = wrapKey(key);
        context.put(key, object);
    }

    public Object get(String key) {
        key = wrapKey(key);
        Object object;
        try {
            object = context.get(key);
        } catch (NullPointerException e) {
            throw new AssertionError(String.format(NO_KEY_MESSAGE, key));
        }
        return object;
    }

    public String str(String key) {
        key = wrapKey(key);
        Object object;
        try {
            object = context.get(key);
        } catch (NullPointerException e) {
            throw new AssertionError(String.format(NO_KEY_MESSAGE, key));
        }
        return object != null ? object.toString() : null;
    }

    public <T> T get(String key, Class<T> userClass) {
        key = wrapKey(key);
        Object object;
        try {
            object = context.get(key);
        } catch (NullPointerException e) {
            throw new AssertionError(String.format(NO_KEY_MESSAGE, key));
        }
        return userClass.cast(object);
    }

    private String wrapKey(String key) {
        return currentThread().getId() + ":" + key;
    }
}

