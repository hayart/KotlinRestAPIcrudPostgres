package am.developer.bookstore.repository

import am.developer.bookstore.entity.BookEntity
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface BookRepository : JpaRepository<BookEntity, Long>