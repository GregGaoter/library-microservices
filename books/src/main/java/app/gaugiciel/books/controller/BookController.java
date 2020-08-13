package app.gaugiciel.books.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.gaugiciel.books.model.Book;

@RestController
@RequestMapping("/books")
public class BookController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	private static List<Book> books = new ArrayList<>(3);
	static {
		books.add(new Book(1, "Paradiction", "Vincent Villa"));
		books.add(new Book(2, "La Chambre aux papillons", "Lucinda Riley"));
		books.add(new Book(3, "Le Loup dans la bergerie", "Fabio M. Mitchelli"));
	}

	@GetMapping
	public List<Book> findAll() {
		return books;
	}

	@GetMapping("/{id}")
	public Book findById(@PathVariable Long id) {
		Book book = null;
		for (Book b : books) {
			if (b.getId() == id) {
				return b;
			}
		}
		log.info("***** Récupération du book d'id " + id);
		return book;
	}

	@PostMapping
	public Book create(@RequestBody Book book) {
		books.add(book);
		return book;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		books.removeIf(book -> book.getId() == id);
	}

	@PutMapping("/{id}")
	public Book update(@RequestBody Book book, @PathVariable Long id) {
		Book b = findById(id);
		b.setTitle(book.getTitle());
		b.setAuthor(book.getAuthor());
		return b;
	}

}
