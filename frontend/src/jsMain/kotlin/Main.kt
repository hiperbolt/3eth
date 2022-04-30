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

fun main() {

    renderComposable(rootElementId = "root") {
        var title by remember { mutableStateOf("") }
        var headerInfo by remember { mutableStateOf(HeaderInfo(emptyList())) }
        var footerInfo by remember { mutableStateOf(FooterInfo(emptyList())) }
        var pageInfo by remember { mutableStateOf(PageInfo(title, headerInfo, footerInfo)) }
        val coroutineScope = rememberCoroutineScope()
        document.title = title

        loginModal()

        page(pageInfo) {
            HashRouter(initRoute = "/") {

                route("/") {
                    Text("Home")
                }

                route("/about") {
                    Text("About")
                }

                route("/login") {
                    Form {


                        Div {
                            Label("username") {
                                Text("Username: ")
                            }
                            Input(type = InputType.Text) {
                                id("username")
                                classes("form-control")
                                placeholder("Username")
                            }
                        }

                        Div {
                            Label("password") {
                                Text("Password: ")
                            }
                            Input(type = InputType.Password) {
                                id("password")
                                classes("form-control")
                                placeholder("Password")
                            }
                        }

                        Div {
                            Input(type = InputType.Button) {
                                classes("btn btn-primary")
                                value("Login")
                                onClick {
                                    coroutineScope.launch {
                                        val result = window.fetch(Constants.API_URL + "/api/v1/private/getToken").await().json().await()


                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}

