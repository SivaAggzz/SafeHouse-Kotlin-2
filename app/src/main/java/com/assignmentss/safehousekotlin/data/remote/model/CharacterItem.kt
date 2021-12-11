package com.assignmentss.safehousekotlin.data.remote.model

data class CharacterItem(
     var birthday: String,
     val img: String,
     val betterCallSaulAppearance: List<Any>,
     val occupation: List<String>,
     val appearance: List<Int>,
     val portrayed: String?,
     val name: String,
     val nickname: String,
     val charId:Int,
     val category: String,
     val status: String


) {
}
