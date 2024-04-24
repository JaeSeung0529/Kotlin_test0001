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

    @PostMapping("/user/create")
    fun createUser(
        @RequestBody request: UserDtoRequest
    ): ResponseEntity<UserDto> {
        val newUser = UserDto(
            email = request.email,
            fullname = request.fullname,
            password = request.password,
        )

        // 생성된 사용자 데이터를 리스트에 추가
        tests.add(newUser)

        // ResponseEntity를 사용하여 OK 응답과 생성된 사용자 데이터 반환
        return ResponseEntity.ok().body(newUser)
    }

    @GetMapping("/lotto")
    fun generateLottoNumbers(): ResponseEntity<List<List<Int>>> {
        val lottoNumbers = mutableListOf<List<Int>>()

        for (i in 1..5) {
            val lotto = generateUniqueLotto()
            lottoNumbers.add(lotto)
        }

        return ResponseEntity.ok().body(lottoNumbers)
    }

    private fun generateUniqueLotto(): List<Int> {
        val lotto = mutableListOf<Int>()
        while (lotto.size < 7) {
            val randomNumber = Random.nextInt(1, 46)
            if (!lotto.contains(randomNumber)) {
                lotto.add(randomNumber)
            }
        }
        return lotto.sorted()
    }

    @PostMapping("/lotto")
    fun generateLottoNumbers(
        @RequestBody request: LottoDtoRequest
    ): ResponseEntity<LottoDto> {
        val lottoNumbers = LottoDto(
            numbers = request.numbers
        )

        return ResponseEntity.ok().body(lottoNumbers)
    }



}