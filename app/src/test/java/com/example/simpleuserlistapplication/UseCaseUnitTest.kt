package com.example.simpleuserlistapplication

import com.example.simpleuserlistapplication.data.UsersUseCase
import com.example.simpleuserlistapplication.model.User
import com.example.simpleuserlistapplication.presentation.SimpleNameViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Before
import org.junit.Rule
import kotlin.test.assertEquals

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
    fun testImplementation(): Unit = runTest {
        coEvery { useCase.getUsers() } returns mockListUsers()
        delay(viewModel.delayTime) // delay to match the delay in the viewModel for the loading to appears :)
        assertEquals("Lucas", viewModel.userState.value.users!![0].name)
    }
}

fun mockListUsers() : List<User> {
    val userTest1 = User("Lucas", "lucas@lucas.com")
    val userTest2 = User("Franco", "franco@franco.com")
    return listOf(userTest1,userTest2)
}
