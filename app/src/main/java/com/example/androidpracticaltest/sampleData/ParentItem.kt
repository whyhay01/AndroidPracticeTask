package com.example.androidpracticaltest.sampleData

import com.example.androidpracticaltest.R

data class ParentItem(
    val title: String,
    val childList: List<Int> = childItemList
)

val childItemList = listOf(
    R.drawable.image_one,
    R.drawable.image_two,
    R.drawable.image_three,
    R.drawable.image_four
)

val parentItemList = listOf(
    ParentItem("Title 1", childItemList),
    ParentItem("Title 2"),
    ParentItem("Title 3"),
    ParentItem("Title 4"),
    ParentItem("Title 5"),
    ParentItem("Title 6"),
    ParentItem("Title 7"),
    ParentItem("Title 8"),
    ParentItem("Title 9"),
    ParentItem("Title 10"),

)
