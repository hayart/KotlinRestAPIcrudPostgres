package am.developer.bookstore.service.impl

import am.developer.bookstore.entity.BookEntity
import am.developer.bookstore.payload.BookRequest
import am.developer.bookstore.payload.BookResponse
import am.developer.bookstore.repository.BookRepository
import am.developer.bookstore.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(private val bookRepository: BookRepository) : BookService {

    override fun getBooks(): List<BookEntity> =
        bookRepository.findAll()

    override fun addBook(bookRequest: BookRequest): ResponseEntity<BookResponse> {
        val book = BookEntity() //null, bookRequest.username, bookRequest.email
        book.email = bookRequest.email
        book.username = bookRequest.username
        val savedEntity = bookRepository.save(book)
        val response = BookResponse()
        response.email = savedEntity.email
        response.username = savedEntity.username
        return ResponseEntity.ok(response)
    }

    override fun getBookById(bookId: Long): ResponseEntity<BookResponse> =
        bookRepository.findById(bookId).map { bookEntity ->
            val response = BookResponse()
            response.email = bookEntity.email
            response.username = bookEntity.username
            ResponseEntity.ok(response)
        }.orElse(ResponseEntity.notFound().build())

    override fun putBook(bookId: Long, updatedBookRequest: BookRequest): ResponseEntity<BookResponse> =
        bookRepository.findById(bookId).map { existingBookEntity ->
            existingBookEntity.email = updatedBookRequest.email
            existingBookEntity.username = updatedBookRequest.username
            val save = bookRepository.save(existingBookEntity)

            var bookResponse = BookResponse()
            bookResponse.id = save.id;
            ResponseEntity.ok().body(bookResponse)
        }.orElse(ResponseEntity.notFound().build())

    override fun deleteBook(bookId: Long): ResponseEntity<Void> =
        bookRepository.findById(bookId).map { book ->
            bookRepository.delete(book)
            ResponseEntity<Void>(HttpStatus.ACCEPTED)
        }.orElse(ResponseEntity.notFound().build())

}