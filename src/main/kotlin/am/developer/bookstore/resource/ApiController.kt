package am.developer.bookstore.resource

import am.developer.bookstore.entity.BookEntity
import am.developer.bookstore.payload.BookRequest
import am.developer.bookstore.payload.BookResponse
import am.developer.bookstore.service.BookService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ApiController(private val bookService : BookService) {

    @GetMapping
    fun getBooks(): List<BookEntity> =
        bookService.getBooks()

    @PostMapping
    fun addBook(@RequestBody request: BookRequest): ResponseEntity<BookResponse> =
        bookService.addBook(request)

    @GetMapping("/{id}")
    fun getBookById(@PathVariable(value="id") bookId: Long): ResponseEntity<BookResponse> =
        bookService.getBookById(bookId)

    @PutMapping("/{id}")
    fun updatebookById(
        @PathVariable(value = "id") bookId: Long,
        @RequestBody newBook: BookRequest): ResponseEntity<BookResponse> =
        bookService.putBook(bookId, newBook)

    @DeleteMapping("/{id}")
    fun deletebook(@PathVariable(value = "id") bookId: Long): ResponseEntity<Void> =
        bookService.deleteBook(bookId)

}