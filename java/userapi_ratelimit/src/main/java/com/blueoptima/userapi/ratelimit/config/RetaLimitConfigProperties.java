package com.blueoptima.userapi.ratelimit.config;

import com.blueoptima.userapi.ratelimit.TimeSpan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "ratelimit")
public class RetaLimitConfigProperties {
    private List<RateLimitProperties> configList;
    private boolean enabled;
    private TimeSpan timespan;
    private int defaultLimit;

    public List<RateLimitProperties> getConfigList() {
        return Collections.unmodifiableList(configList);
    }

    public void setConfigList(List<RateLimitProperties> configList) {
        this.configList = configList;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public TimeSpan getTimespan() {
        return timespan;
    }

    public void setTimespan(TimeSpan timespan) {
        this.timespan = timespan;
    }

    public int getDefaultLimit() {
        return defaultLimit;
    }

    public void setDefaultLimit(int defaultLimit) {
        this.defaultLimit = defaultLimit;
    }
}

