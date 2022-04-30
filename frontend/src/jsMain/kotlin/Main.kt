import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import app.softwork.routingcompose.HashRouter
import kotlinx.browser.document
import kotlinx.coroutines.launch
import models.FooterInfo
import models.HeaderInfo
import models.MenuItem
import models.PageInfo
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import kotlinx.browser.window
import kotlinx.coroutines.await
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.HTMLInputElement
import views.loginView
import views.productsView
import views.searchView

fun main() {

    renderComposable(rootElementId = "root") {
        var title by remember { mutableStateOf("3Eth") }
        var headerInfo by remember { mutableStateOf(HeaderInfo(listOf(MenuItem("Products", "products")))) }
        var footerInfo by remember { mutableStateOf(FooterInfo(emptyList())) }
        var pageInfo by remember { mutableStateOf(PageInfo(title, headerInfo, footerInfo)) }
        var searchValue by remember { mutableStateOf("") }

        val coroutineScope = rememberCoroutineScope()
        document.title = title

        loginModal()

        page(pageInfo) {
            HashRouter(initRoute = "/") {

                route("/") {
                    Text("Home")
                }

                route("/products") {
                    productsView(coroutineScope)
                }

                route("/login") {
                    loginView(coroutineScope)
                }

                route("/search") {
                    searchView(searchValue, coroutineScope)
                }
            }
        }
    }
}

