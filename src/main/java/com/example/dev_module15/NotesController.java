package com.example.dev_module15;

import com.example.dev_module15.crud.NoteService;
import com.example.dev_module15.entity.Note;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/note")
public class NotesController {
    private final NoteService noteService;

    @Autowired
    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public ModelAndView getTime() {

        ModelAndView result = new ModelAndView("list");

        result.addObject("list", noteService.listAll());
        return result;
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public ModelAndView deleteNote
            (@RequestParam(value = "id") long id) {

        ModelAndView result = new ModelAndView("list");
        noteService.deleteById(id);
        result.addObject("list", noteService.listAll());
        return result;
    }

    @RequestMapping(value = "/edit", method = {RequestMethod.POST})
    public ModelAndView editNote
            (@RequestParam(value = "id") long id) {

        ModelAndView result = new ModelAndView("update");
        result.addObject("note", noteService.getById(id));
        return result;
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public ModelAndView updateNote
            (@RequestParam(value = "id") long id ,
             @RequestParam(name = "title") String title ,
             @RequestParam(name = "content") String content) {

        Note updateNote = new Note(title,content);
        updateNote.setId(id);
        noteService.update(updateNote);

        ModelAndView result = new ModelAndView("list");
        result.addObject("list", noteService.listAll());
        return result;
    }

    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    public ModelAndView createNote
            (@RequestParam(name = "title") String title ,
             @RequestParam(name = "content") String content) {

        Note newNote = new Note(title,content);
        noteService.add(newNote);

        ModelAndView result = new ModelAndView("list");
        result.addObject("list", noteService.listAll());
        return result;
    }
}