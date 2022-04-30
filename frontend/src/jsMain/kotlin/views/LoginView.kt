package views

import androidx.compose.runtime.Composable
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLInputElement

@Composable
fun loginView(coroutineScope: CoroutineScope) {

    Form {
        H1 ({}){
            Text("Login")
        }

        Div ({classes("mb-3")}) {
            Label("username") {
                Text("Username: ")
            }
            Input(type = InputType.Text) {
                id("username")
                classes("form-control")
                placeholder("Username")
            }
        }

        Div ({classes("mb-3")}){
            Label("password") {
                Text("Password: ")
            }
            Input(type = InputType.Password) {
                id("password")
                classes("form-control")
                placeholder("Password")
            }
        }

        Div ({classes("mb-3", "d-grid", )}){
            Input(type = InputType.Button) {
                classes("btn", "btn-primary")
                value("Login")
                onClick {
                    coroutineScope.launch {
                        val password:String = (document.getElementById("password") as HTMLInputElement?)?.value ?: ""
                        val username:String = (document.getElementById("username") as HTMLInputElement?)?.value ?: ""
                        val result = window.fetch(Constants.API_URL + "/api/v1/private/getToken/$username/$password").await().json().await()
                        window.alert(result.toString())
                    }
                }
            }
        }
    }

}