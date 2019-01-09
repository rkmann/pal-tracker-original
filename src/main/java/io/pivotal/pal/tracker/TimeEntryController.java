package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

import static java.util.Objects.isNull;

@RestController
public class TimeEntryController {


    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
            //this.timeEntryRepository = new InMemoryTimeEntryRepository();
        this.timeEntryRepository = timeEntryRepository;  //This is changed by Raymond
    }

    @PostMapping("/time-entries")
    //@RequestMapping(value = "/time-entries", method = RequestMethod.POST)
    public ResponseEntity create( @RequestBody TimeEntry timeEntryToCreate) {

        return new ResponseEntity<>(timeEntryRepository.create(timeEntryToCreate),  HttpStatus.CREATED);
    }

    //@RequestMapping(value = "/time-entries/{id}", method = RequestMethod.GET)
    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry timeEntry = this.timeEntryRepository.find(id);
        if(isNull(timeEntry)){
            return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.OK);
        }
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<List<TimeEntry>>(this.timeEntryRepository.list(), HttpStatus.OK);
    }



    //@RequestMapping(value = "/time-entries", method = RequestMethod.PUT)
    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(@PathVariable long id,@RequestBody TimeEntry expected) {

        TimeEntry timeEntry = this.timeEntryRepository.update(id,expected);
        if(isNull(timeEntry)){
            return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.OK);
        }

    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {
        this.timeEntryRepository.delete(id);
        return new ResponseEntity<TimeEntry>(new TimeEntry(), HttpStatus.NO_CONTENT);
    }
}


