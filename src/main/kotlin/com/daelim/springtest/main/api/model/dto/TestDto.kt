package com.daelim.springtest.main.api.model.dto

//data class TestDto(
//    val id: String,
//    val address: String,
//    val email: String,
//    val tel: String? = null,
//    val age: Int,
//)
//
//data class TestDtoRequest(
//    val id: String,
//)

data class UserDto(
    val email: String,
    val fullname: String,
    val password: String,

)

data class UserDtoRequest(
    val fullname: String,
    val email: String,
    val password: String,
)

data class LottoDto(
    val numbers: List<List<Int>>
)
data class LottoDtoRequest(
    val numbers: List<List<Int>>
)