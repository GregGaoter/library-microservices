package app.gaugiciel.library.clientui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import app.gaugiciel.library.clientui.bean.Book;
import app.gaugiciel.library.clientui.proxy.BooksProxy;

@Controller
@RequestMapping("/books")
public class ClientController {

	@Autowired
	private BooksProxy booksProxy;

	@GetMapping("/{id}")
	public String afficherBook(@PathVariable Long id, Model model) {
		Book book = booksProxy.findById(id);
		model.addAttribute("book", book);
		return "book";
	}

}
