package views

import Constants
import androidx.compose.runtime.Composable
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch

@Composable
fun searchView(term: String, coroutineScope: CoroutineScope) {
    coroutineScope.launch {
        val result = window.fetch(Constants.API_URL + "/api/v1/publicQuery/$term").await().json().await()
        println(result)
    }
}