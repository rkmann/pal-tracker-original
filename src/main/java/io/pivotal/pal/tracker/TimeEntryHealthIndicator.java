package io.pivotal.pal.tracker;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimeEntryHealthIndicator implements HealthIndicator {

    private static final int MAX_TIME_ENTRIES = 5;
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryHealthIndicator(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository ;

    }

    @Override
    public Health health() {
        Health.Builder builder = new Health.Builder();

        if(timeEntryRepository.list().size() < MAX_TIME_ENTRIES) {
            builder.up();
        } else {
            builder.down();
        }

        return builder.build();
    }

}
