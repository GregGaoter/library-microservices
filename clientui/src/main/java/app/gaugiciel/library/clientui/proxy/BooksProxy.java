package app.gaugiciel.library.clientui.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import app.gaugiciel.library.clientui.bean.Book;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "books")
@RequestMapping("/books/books")
public interface BooksProxy {

	@GetMapping
	List<Book> findAll();

	@GetMapping("/{id}")
	Book findById(@PathVariable("id") Long id);

	@PostMapping
	Book create(@RequestBody Book book);

	@DeleteMapping("/{id}")
	void delete(@PathVariable("id") Long id);

	@PutMapping("/{id}")
	Book update(@RequestBody Book book, @PathVariable("id") Long id);

}
