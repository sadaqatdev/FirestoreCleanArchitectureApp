package ro.hunzaautos.app.presentation.books

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ro.hunzaautos.app.domain.model.Book
import ro.hunzaautos.app.domain.model.Response
import ro.hunzaautos.app.domain.model.Response.Success
import ro.hunzaautos.app.domain.use_case.UseCases
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    private val _booksState = mutableStateOf<Response<List<Book>>>(Response.Loading)

    val booksState: State<Response<List<Book>>> = _booksState

    private val _isBookAddedState = mutableStateOf<Response<Void?>>(Success(null))

    val isBookAddedState: State<Response<Void?>> = _isBookAddedState

    var openDialogState = mutableStateOf(false)

    private val _isBookDeletedState = mutableStateOf<Response<Void?>>(Success(null))

    val isBookDeletedState: State<Response<Void?>> = _isBookDeletedState

    init {
        getBooks()
    }

    private fun getBooks() {
        viewModelScope.launch {
            useCases.getBooks().collect { response ->
                _booksState.value = response
            }
        }
    }

    fun addBook(title: String, author: String) {
        viewModelScope.launch {
            useCases.addBook(title, author).collect { response ->
                _isBookAddedState.value = response
            }
        }
    }

    fun deleteBook(bookId: String) {
        viewModelScope.launch {
            useCases.deleteBook(bookId).collect { response ->
                _isBookDeletedState.value = response
            }
        }
    }
}