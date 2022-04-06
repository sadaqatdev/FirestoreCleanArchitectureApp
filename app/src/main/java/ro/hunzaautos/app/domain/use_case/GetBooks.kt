package ro.hunzaautos.app.domain.use_case

import ro.hunzaautos.app.domain.repository.BooksRepository

class GetBooks (
    private val repository: BooksRepository
) {
    operator fun invoke() = repository.getBooksFromFirestore()
}