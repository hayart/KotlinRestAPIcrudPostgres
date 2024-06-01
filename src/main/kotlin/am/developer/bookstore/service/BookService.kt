package am.developer.bookstore.service


import am.developer.bookstore.entity.BookEntity
import am.developer.bookstore.payload.BookRequest
import am.developer.bookstore.payload.BookResponse
import org.springframework.http.ResponseEntity


interface BookService {
    fun getBooks(): List<BookEntity>;
    fun addBook(book: BookRequest): ResponseEntity<BookResponse>;
}