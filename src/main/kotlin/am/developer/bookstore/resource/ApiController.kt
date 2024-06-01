package am.developer.bookstore.resource

import am.developer.bookstore.entity.BookEntity
import am.developer.bookstore.payload.BookRequest
import am.developer.bookstore.payload.BookResponse
import am.developer.bookstore.service.BookService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

// Example of a simple REST controller in Kotlin
@RestController
@RequestMapping("/api")
class ApiController(private val bookService : BookService) {

    @GetMapping("/hello")
    fun sayHello(): String {
        return "Hello, Kotlin and Spring Boot jpa!"
    }

    @GetMapping
    fun getBooks(): List<BookEntity> =
        bookService.getBooks()

    @PostMapping
    fun addTask(@RequestBody request: BookRequest): ResponseEntity<BookResponse> =
        bookService.addBook(request)

}