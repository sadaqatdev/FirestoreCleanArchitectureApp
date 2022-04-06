package ro.hunzaautos.app.domain.use_case

import ro.hunzaautos.app.domain.repository.BooksRepository

class AddBook(
    private val repository: BooksRepository
) {
    suspend operator fun invoke(
        title: String,
        author: String
    ) = repository.addBookToFirestore(title, author)
}