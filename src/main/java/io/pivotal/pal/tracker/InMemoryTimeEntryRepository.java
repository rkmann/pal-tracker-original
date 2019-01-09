package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

//@Repository(value ="InMemoryTimeEntryRepository")
public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private Map<Long, TimeEntry> timeEntries;


    public InMemoryTimeEntryRepository(){
        this.timeEntries = new HashMap<Long, TimeEntry>();

    }
    public TimeEntry create(TimeEntry timeEntry) {

        if(this.timeEntries.size()==0){
            long num = this.timeEntries.size()+1L;
            timeEntry.setTimeEntryId(num);
            this.timeEntries.put(num, timeEntry);


        }else {

            if(timeEntry.getId()==0L){
                timeEntry.setTimeEntryId(this.timeEntries.size() + 1);
            }

            if(this.timeEntries.containsKey(timeEntry.getId())) {
                this.timeEntries.replace(timeEntry.getId(), timeEntry);
            }else{
                this.timeEntries.put(timeEntry.getId(), timeEntry);
            }
        }

        return timeEntry;
    }
    
    public TimeEntry find(long id){

       return this.timeEntries.get(id);

    }

    public List<TimeEntry> list() {
            return new ArrayList<>(this.timeEntries.values());

    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntry.setTimeEntryId(id);
        this.timeEntries.replace(id, timeEntry);
        return find(id);
    }

    public void delete(long id) {

        this.timeEntries.remove(id);

    }
}
