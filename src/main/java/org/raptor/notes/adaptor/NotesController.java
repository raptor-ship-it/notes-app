package org.raptor.notes.adaptor;


import org.raptor.notes.domain.model.Note;
import org.raptor.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {
    /** --- members --*/

    @Autowired
    private NoteService noteService;

    public NotesController() {
        super();
    }

    @GetMapping(path = "/test" ,  produces = MediaType.APPLICATION_JSON_VALUE )
    public void testController() {
        System.out.println("In controller...");

        return;
    }


    @GetMapping(path = "/all" , produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> getAllNotes() {
        final List<Note> notes = noteService.getAllNotes();

        ResponseEntity<?> response;
        if ( notes == null || notes.isEmpty() ) {
            response = new ResponseEntity<>("notes not found." , HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<>(notes, HttpStatus.OK);
        }

        return response;
    }


    @GetMapping(path = "{id}" , produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> getNote( @PathVariable("id") final String noteId) {
        final Note note = noteService.getNote(noteId);

        ResponseEntity<?> response;
        if (note == null ) {
            response = new ResponseEntity<>(String.format("note with Id [%s] not found.", noteId),
                    HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<>(note , HttpStatus.OK);
        }

        return response;
    }


    @PostMapping(path = "/create" , consumes = MediaType.APPLICATION_JSON_VALUE ,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNote(@RequestBody final String noteText) {
        final ResponseEntity<?> response;
        final Note note  = noteService.addNote(noteText);
        if ( note == null ) {
            response = new ResponseEntity<>("note not added, please try later." , HttpStatus.FORBIDDEN);
        } else {
            response = new ResponseEntity<>(note , HttpStatus.OK);
        }

        return response;
    }

}