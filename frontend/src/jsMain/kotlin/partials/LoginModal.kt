import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun loginModal() {
    Div({ classes("modal"); id("loginModal") }) {
        Div({ classes("modal-dialog", "modal-dialog-centered", "modal-dialog-scrollable") }) {
            Div({ classes("modal-content") }) {
                Div({ classes("modal-header") }) {
                    H5({ classes("modal-title") }) {
                        Text("Login")
                    }
                    Button({
                        classes("close"); attr("type", "button"); attr(
                        "data-bs-dismiss",
                        "modal"
                    ); attr("aria-label", "Close")
                    }) {
                        Div({ classes("close-icon") }) {
                            Text("×")
                        }
                    }
                }
                Div({ classes("modal-body") }){
                    P{
                        Text("Please login to continue")
                    }
                }
                Div({ classes("modal-footer") }) {
                    Button({
                        classes("btn"); attr("type", "button");
                    }) {
                        Text("Login")
                    }
                }

            }
        }
    }
}