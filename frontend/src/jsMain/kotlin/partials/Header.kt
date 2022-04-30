package partials

import androidx.compose.runtime.Composable
import models.HeaderInfo
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.*

@Composable
fun header(title: String, headerInfo: HeaderInfo) {
    Nav ({ classes("navbar", "navbar-dark", "bg-dark", "navbar-expand-lg")}) {
        Div({ classes("container-fluid")}) {
            A( "#", { classes("navbar-brand")}) {
                Text(title)
            }
            Button ({ classes("navbar-toggler"); attr("type", "button"); attr("data-bs-toggle", "collapse"); attr("data-bs-toggle", "#navbarNavDropdown"); attr("aria-controls", "navbarNavDropdown"); attr("aria-expanded", "false"); attr("aria-label", "Toggle navigation")}) {
                Span({ classes("navbar-toggler-icon")})
            }
            Div({ classes("collapse", "navbar-collapse"); attr("id", "navbarNavDropdown")}) {
                Ul({ classes("navbar-nav", "me-auto")}) {
                    headerInfo.menuItems.forEach {
                        Li({ classes("nav-item")}) {
                            A("#/${it.href}", { classes("nav-link")}) {
                                Text(it.name)
                            }
                        }
                    }
                }
                Form("https://jetbrains.com/compose/search", { classes("d-flex","float-end"); attr("method", "get")}) {
                    Input(InputType.Text) {
                        classes("form-control", "me-2")
                        attr("name", "q")
                        attr("placeholder", "Search")
                        attr("aria-label", "Search")
                    }
                    Button({ classes("btn", "btn-outline-success"); attr("type", "submit")}) {
                        Text("Search")
                    }
                }
            }
        }
    }
}