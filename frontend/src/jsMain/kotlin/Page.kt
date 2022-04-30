import androidx.compose.runtime.Composable
import models.PageInfo
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement
import partials.footer
import partials.header

@Composable
fun page(pageInfo: PageInfo, block: ContentBuilder<HTMLDivElement>) {
    header(pageInfo.title, pageInfo.headerInfo)
    Div ({classes("container-fluid")}, block)
    footer(pageInfo.title, pageInfo.footerInfo)
}