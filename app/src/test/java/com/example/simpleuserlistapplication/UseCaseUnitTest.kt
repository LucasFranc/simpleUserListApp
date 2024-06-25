package com.example.simpleuserlistapplication

import com.example.simpleuserlistapplication.data.UsersUseCase
import com.example.simpleuserlistapplication.model.User
import com.example.simpleuserlistapplication.presentation.SimpleNameViewModel
import io.mockk.mockk
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.junit.Rule
import kotlin.test.assertTrue

class ExampleUnitTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private val useCase = mockk<UsersUseCase>()
    private lateinit var viewModel: SimpleNameViewModel
    private fun createViewModel() = SimpleNameViewModel(useCase)

    @Before
    fun setup(){
        viewModel = createViewModel()
    }

    @Test
    fun `test regex Email Success`() {
       assertTrue(viewModel.validateResponseEmail(mockListUsers()))
    }

    @Test
    fun `test regex Email Fail`() {
        assertFalse(viewModel.validateResponseEmail(mockErrorListUsers()))
    }
}

fun mockListUsers() : List<User> {
    val userTest1 = User("Lucas", "lucas@lucas.com")
    val userTest2 = User("Franco", "franco@franco.com")
    return listOf(userTest1,userTest2)
}

fun mockErrorListUsers() : List<User> {
    val userTest1 = User("Lucas", "lucaslucascom")
    val userTest2 = User("Franco", "francofrancocom")
    return listOf(userTest1,userTest2)
}
