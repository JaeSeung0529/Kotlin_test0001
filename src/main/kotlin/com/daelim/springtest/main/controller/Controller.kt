package com.daelim.springtest.main.controller

import com.daelim.springtest.main.api.model.dto.*


import io.swagger.v3.oas.annotations.Parameter
import jakarta.validation.Valid
import net.datafaker.Faker
import org.apache.catalina.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class Controller {

    val tests = mutableListOf<UserDto>()

    @PostMapping("/user/login")
    fun postTestDto(
        @RequestBody request: UserDtoRequest
    ): ResponseEntity<UserDto> {
        val test = UserDto(
            email = request.email,
            fullname = request.fullname,
            password = request.password
        )

        // 생성된 데이터를 리스트에 추가
        tests.add(test)

        // ResponseEntity를 사용하여 OK 응답과 생성된 데이터 반환
        return ResponseEntity.ok().body(test)
    }


//
    /*private val lotto = mutableListOf<LottoDto>()
    private val tests = mutableListOf<TestDto>()
    private val users = mutableListOf<UserDto>()


        @PostMapping("/user/login")
        fun postTestDto(
            @RequestBody request: UserDtoRequest
        ): ResponseEntity<LottoDto> {
            val test = UserDto(
                email = request.email,
                fullname = request.fullname,
                password = request.password
            )

            // 생성된 데이터를 리스트에 추가
            users.add(test)

            // ResponseEntity를 사용하여 OK 응답과 생성된 데이터 반환
            return ResponseEntity.ok().body(test)
        }*/

        @PostMapping("/user/create")
        fun loginUser(@RequestBody request: UserDto): ResponseEntity<UserDto> {
            // 받은 요청의 데이터를 그대로 응답에 사용
            val response = UserDto(
                fullName = request.fullName,
                email = request.email,
                password = request.password
            )

            return ResponseEntity.ok().body(response)
        }



//    @PostMapping("/user/login")
//    fun postTestDto(
//        @RequestBody lottoDtoRequest: LottoDtoRequest
//    ): ResponseEntity<LottoDto> {
//        val faker = Faker(Locale.KOREA)
//        val test = LottoDto(
//            fullname = lottoDtoRequest.fullname,
//            email = faker.internet().emailAddress(),
//            password = Random().nextInt(10).toString(),
//        )
//        lotto.add(test)
//        return ResponseEntity.ok().body(test)
//    }
//    @GetMapping("/test")
//    fun getAllTestDto(
//    ): ResponseEntity<List<TestDto>> {
//        val response = tests
//        return ResponseEntity.ok().body(response)
//    }
//
//    @GetMapping("/test/{id}")
//    fun getTestDto(
//        @PathVariable("id") userId: String
//    ): ResponseEntity<TestDto> {
//        val response = tests.firstOrNull{it.id == userId}
//        return ResponseEntity.ok().body(response)
//    }
//@RestController
//class UserController {
//
//    // 임시 데이터베이스 대신 사용할 가짜 사용자 데이터
//    val users = listOf(
//        User("John Doe", "johndoe@example.com", "password123"),
//        User("Jane Smith", "janesmith@example.com", "abc123")
//    )
//
//    @PostMapping("/user/login")
//    fun login(@RequestBody request: LoginRequest): Any {
//        // 이메일과 비밀번호가 제공되었는지 확인
//        if (request.email.isNullOrEmpty() || request.password.isNullOrEmpty()) {
//            return mapOf("error" to "이메일과 비밀번호를 모두 입력해주세요.")
//        }
//
//        // 사용자 찾기
//        val user = users.find { it.email == request.email && it.password == request.password }
//
//        // 사용자가 없거나 비밀번호가 일치하지 않으면 에러 반환
//        if (user == null) {
//            return mapOf("error" to "이메일 또는 비밀번호가 잘못되었습니다.")
//        }
//
//        // 인증에 성공하면 사용자 정보 반환
//        return mapOf(
//            "fullName" to user.fullName,
//            "email" to user.email,
//            "password" to user.password
//        )
//    }
//}
}}