package com.blueoptima.userapi.ratelimit.utils;

import com.blueoptima.userapi.ratelimit.TimeSpan;
import com.blueoptima.userapi.ratelimit.config.RateLimitProperties;
import com.blueoptima.userapi.ratelimit.config.RetaLimitConfigProperties;
import com.blueoptima.userapi.ratelimit.store.ValueStore;

import java.util.Objects;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Utils {

    public static final long ONE_DAY_IN_MILLIS = 86400000;

    public static int getRateLimitFromConfig(
            final RetaLimitConfigProperties retaLimitConfigProperties,
            final String userName,
            final String api
    ) {
        int limit = retaLimitConfigProperties.getDefaultLimit();
        Optional<RateLimitProperties> rateLimit = Optional.empty();

        if (isNotBlank(userName) && isNotBlank(api) && retaLimitConfigProperties.isEnabled()) {
            rateLimit = retaLimitConfigProperties.getConfigList().stream().filter(
                    config -> Objects.equals(config.getUserName(), userName) && Objects.equals(config.getApi(), api)
            ).findFirst();
        }

        if (rateLimit.isPresent() && rateLimit.get().getLimit() > 0) {
            limit = rateLimit.get().getLimit();
        }

        return limit;
    }

    public static boolean isRateLimitExceed(final int limit, final long currentTime, final ValueStore valueStore) {
        return limit == valueStore.getCurrentLimit();
    }

    public static boolean
    isResetRateLimit(final long currentTime, final ValueStore valueStore, TimeSpan timespan) {
        long timeDifference = currentTime - valueStore.getInitTimeInMillis();

        return timeDifference > timespan.getTimeSpanValueInMills();
    }
}
