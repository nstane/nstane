package com.blueoptima.userapi.ratelimit;

import com.blueoptima.userapi.ratelimit.config.RetaLimitConfigProperties;
import com.blueoptima.userapi.ratelimit.exception.RateLimitException;
import com.blueoptima.userapi.ratelimit.store.KeyStore;
import com.blueoptima.userapi.ratelimit.store.ValueStore;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import static com.blueoptima.userapi.ratelimit.utils.Utils.*;

@Component
public class RateLimitHandler {
    private final ConcurrentHashMap<KeyStore, ValueStore> store = new ConcurrentHashMap<>();

    public void handle(
            final HttpServletRequest request,
            final RetaLimitConfigProperties retaLimitConfigProperties
    ) {
        final String userName = request.getHeader("User-Name");

        final String api = request.getRequestURI();

        final int limit = getRateLimitFromConfig(retaLimitConfigProperties, userName, api);

        if (limit > 0) {
            final long currentTime = System.currentTimeMillis();
            final KeyStore keyStore = buildKeyStore(api, userName);
            final ValueStore valueStore = store.get(keyStore);

            if (Objects.isNull(valueStore)) {
                store.put(keyStore, buildValueStore(currentTime));
                return;
            }

            boolean resetRateLimit = isResetRateLimit(currentTime, valueStore, retaLimitConfigProperties.getTimespan());

            if (isRateLimitExceed(limit, currentTime, valueStore) && !resetRateLimit) {
                throw new RateLimitException("Rate limit exceed", RateLimitException.ERROR_CODE);
            } else {
                resetOrUpdateStore(keyStore, resetRateLimit, currentTime);
            }
        } else {
            throw new IllegalArgumentException("Default Rate limit missing");
        }
    }

    private void resetOrUpdateStore(final KeyStore keyStore, final boolean resetRateLimit, final long currentTime) {
        if (resetRateLimit) {
            store.put(keyStore, buildValueStore(currentTime));
        } else {
            incrementLimitAndUpdateStore(keyStore);
        }
    }

    private void incrementLimitAndUpdateStore(final KeyStore keyStore) {
        final ValueStore valueStore = store.get(keyStore);
        valueStore.increaseRateLimit();
        store.put(keyStore, valueStore);
    }

    private KeyStore buildKeyStore(final String userName, final String api) {
        return new KeyStore(api, userName);
    }

    private ValueStore buildValueStore(final long currentTime) {
        return new ValueStore(1, currentTime);
    }
}
