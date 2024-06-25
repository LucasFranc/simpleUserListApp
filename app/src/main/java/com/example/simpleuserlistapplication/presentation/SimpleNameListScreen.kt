package com.example.simpleuserlistapplication.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simpleuserlistapplication.R
import com.example.simpleuserlistapplication.model.User
import org.koin.androidx.compose.koinViewModel

@Composable
fun SimpleNameListScreen(modifier: Modifier = Modifier) {

    val simpleNameViewModel: SimpleNameViewModel = koinViewModel()
    val viewState by simpleNameViewModel.userState

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                ErrorScreen(stringResource(R.string.error_occurred))
            }

            viewState.users != null -> {
                CategoryScreen(users = viewState.users)
            }

            else -> {
                ErrorScreen(stringResource(R.string.unexpected_error_occurred))
            }
        }
    }
}

@Composable
private fun ErrorScreen(error : String) {
    Text(error)
}

@Composable
fun CategoryScreen(users: List<User>?) {
    users?.let {
        LazyVerticalGrid(GridCells.Fixed(1), modifier = Modifier.fillMaxSize()) {
            items(it) { user ->
                UserItem(user = user)
            }
        }
    }
}

@Composable
fun UserItem(user: User) {
    Column(
        modifier = Modifier
            .clickable(
                onClick = { },
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple()
            )
            .fillMaxSize(),
    )
    {
        ListItem(
            headlineContent = {
                Text(
                    text = AnnotatedString(
                        user.name ?: stringResource(R.string.not_found_name)
                    )
                )
            },
            supportingContent = {
                Text(
                    text = AnnotatedString(
                        user.email ?: stringResource(R.string.not_found_e_mail)
                    )
                )
            }
        )
        HorizontalDivider()
    }
}