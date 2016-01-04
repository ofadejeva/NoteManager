package app.controller;


import java.io.FileNotFoundException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import app.dao.NoteDAOImpl;
import app.model.Note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping("/")
@Scope("session")
public class NoteBookController extends HttpServlet implements Serializable {
	
	@Autowired
	private NoteDAOImpl dao;
	
	private static final long serialVersionUID = 3918673777710626949L;


	
    @RequestMapping(value ="/addNote", method = RequestMethod.POST)
    public String addNote(ModelMap model, @ModelAttribute("note") Note note) {
    	dao.save(new Note(note.getName(), note.getContent()));
        model.addAttribute("notes",(ArrayList<Note>)  dao.findAll());
        return "redirect:/notes";
    }
    
    @RequestMapping(value = "/addNote", method = RequestMethod.GET)
    public void addNote(ModelMap model) {
        model.addAttribute("note", new Note());       
    }
    
    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String displayAllNotes(ModelMap model) {
    	model.addAttribute("notes",  (ArrayList<Note>) dao.findAll());
    	return "notes";
}
    
    @RequestMapping(value = "/notes/{name}", method = RequestMethod.GET)
    public String displayNoteByName(ModelMap model, @PathVariable("name") String name) {
    	model.addAttribute("note", dao.getNote(name));
    	return "note";
}
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteNotes(ModelMap model) {
    	dao.deleteAllNotes();
    	return "redirect:/notes";
    }
    
    @RequestMapping(value = "/deleteSelectedNotes", method = RequestMethod.POST)
    public String deleteSelectedNotes(ModelMap model,  HttpServletRequest request) throws FileNotFoundException, UnsupportedEncodingException {
    	String[] selectedNotes = request.getParameterValues("selected");
    	dao.deleteNotesByName(Arrays.asList(selectedNotes));
    	return "redirect:/notes";
    }
    
}