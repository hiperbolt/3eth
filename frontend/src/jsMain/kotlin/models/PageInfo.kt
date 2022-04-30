package models

import kotlinx.serialization.Serializable

@Serializable
data class PageInfo(val title: String,  val headerInfo: HeaderInfo, val footerInfo: FooterInfo)