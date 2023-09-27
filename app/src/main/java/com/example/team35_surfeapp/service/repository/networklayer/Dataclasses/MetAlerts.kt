package com.example.team35_surfeapp.service.repository.networklayer.Dataclasses

import org.simpleframework.xml.*


@Root(name = "rss", strict = false)
data class MetAlerts @JvmOverloads constructor(

    @field:Attribute(name = "version", required = true)
    @param:Attribute(name = "version", required = true)
    var version: String? = "",

    @field: Element(name = "channel", required = true)
    @param: Element(name = "channel", required = true)
    var channel: Channel? = null

    ) {
        @Root(name= "channel", strict = false)
        data class Channel @JvmOverloads constructor(

            @field: Element(name = "title", required = true)
            @param: Element(name = "title", required = true)
            var title: String? = "",

            @field: Element(name = "link")
            var link: String? = "",

            @field: Element(name = "description")
            var description: String? = "",

            @field: Element(name = "language")
            var language: String? = "",

            @field: Element(name = "copyright")
            var copyright: String? = "",

            @field: Element(name = "pubDate")
            var pubDate: String? = "",

            @field: Element(name = "lastBuildDate")
            var lastBuildDate: String? = "",

            @field: Element(name = "category")
            var category: String? = "",

            @field: Element(name = "generator")
            var generator: String? = "",

            @field: Element(name = "docs")
            var docs: String? = "",

            @field: Element(name = "image")
            var image: Image? = null,

            @field: ElementList(name = "item", inline = true)
            var items: List<Item?>? = null

        ) {
            @Root(name = "image", strict = false)
            data class Image (

                @field: Element(name = "title")
                var title: String? = null,

                @field: Element(name = "link")
                var link: String? = null,

                @field: Element(name = "url")
                var url: String? = null
            )

            @Root(name = "item")
            data class Item @JvmOverloads constructor(

                @Path("channel/item/title")
                @field: Element(name = "title")
                var title: String? = "",

                @field: Element(name = "description")
                var description: String? = "",

                @field: Element(name = "link")
                var link: String? = "",

                @field: Element(name = "author")
                var author: String? = "",

                @field: Element(name = "category")
                var category: String? = "",

                @field: Element(name = "guid")
                var guid: String? = "",

                @field: Element(name = "pubDate")
                var pubDate: String? = ""
            )
        }
    }



