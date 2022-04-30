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
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {

    renderComposable(rootElementId = "root") {
        var title by remember { mutableStateOf("") }
        var headerInfo by remember { mutableStateOf(HeaderInfo(emptyList())) }
        var footerInfo by remember { mutableStateOf(FooterInfo(emptyList())) }
        var pageInfo by remember { mutableStateOf(PageInfo(title, headerInfo, footerInfo)) }

        document.title = title

        page(pageInfo) {
            HashRouter(initRoute = "/") {

                route("/") {
                    Text("Home")
                }

                route("/about") {
                    Text("About")
                }

            }
        }
    }
}

