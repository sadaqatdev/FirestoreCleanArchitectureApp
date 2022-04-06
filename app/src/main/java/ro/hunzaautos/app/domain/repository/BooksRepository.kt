package ro.hunzaautos.app.domain.repository

import kotlinx.coroutines.flow.Flow
import ro.hunzaautos.app.domain.model.Book
import ro.hunzaautos.app.domain.model.Response

interface BooksRepository {
    fun getBooksFromFirestore(): Flow<Response<List<Book>>>

    suspend fun addBookToFirestore(title: String, author: String): Flow<Response<Void?>>

    suspend fun deleteBookFromFirestore(bookId: String): Flow<Response<Void?>>
}