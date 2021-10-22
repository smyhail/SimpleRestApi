package com.sub.controller;

import com.sub.model.Note;
import com.sub.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/notes")
    public List<Note> getNote(){
        return noteService.getAllNote();
    }

    @GetMapping("/notes/{id}")
    public Note getSingleNote (@PathVariable long id){
        return noteService.getSingleNote(id);
    }

    @PostMapping("/note")
    public Note addNote(@RequestBody Note note){
        return noteService.addNote(note);
    }

    @PutMapping("/note")
    public Note editNote(@RequestBody Note note){
        return noteService.editNote(note);
    }

    @DeleteMapping("/notes")
    public void deleteNote(@PathVariable long id){
        noteService.deleteNote(id);
    }
}
