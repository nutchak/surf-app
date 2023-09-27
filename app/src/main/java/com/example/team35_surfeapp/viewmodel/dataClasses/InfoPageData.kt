package com.example.team35_surfeapp.viewmodel.dataClasses

data class InfoPageData(val weatherSymbolCode: String?,
                        val weatherName: String?,
                        val time: String?,
                        val cardData: MutableList<CardData>)

data class CardData(val title: String?,
                    var data: String?,
                    val exstraData: Double?,
                    var unit: String,
                    val icon: String)