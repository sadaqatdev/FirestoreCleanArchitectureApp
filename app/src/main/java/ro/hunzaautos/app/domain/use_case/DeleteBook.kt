package ro.hunzaautos.app.domain.use_case

import ro.hunzaautos.app.domain.repository.BooksRepository

class DeleteBook(
    private val repository: BooksRepository
) {
    suspend operator fun invoke(bookId: String) = repository.deleteBookFromFirestore(bookId)
}