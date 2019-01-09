package io.pivotal.pal.tracker;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;

@Component
public class TimeEntry {

    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;
    private long timeEntryId;

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate date, int hours) {
        this.timeEntryId = timeEntryId;
        this.userId = userId;
        this.projectId = projectId;
        this.date = date;
        this.hours = hours;
    }
    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {

        this.userId = userId;
        this.projectId = projectId;
        this.date = date;
        this.hours = hours;
        this.timeEntryId = new Long(0);
    }

    public TimeEntry(){

    }

    public long getId(){
       return this.getTimeEntryId();
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public long getTimeEntryId() {
        return timeEntryId;
    }

    public void setTimeEntryId(long timeEntryId) {
        this.timeEntryId = timeEntryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeEntry timeEntry = (TimeEntry) o;

        return (this.hashCode() == timeEntry.hashCode());
    }

    @Override
    public int hashCode() {
        int result = (int) (projectId ^ (projectId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + date.hashCode();
        result = 31 * result + hours;
        System.out.println("Hashcode: " + result);
        return result;
    }
}
