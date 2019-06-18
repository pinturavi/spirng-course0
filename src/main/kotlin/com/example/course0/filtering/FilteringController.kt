package com.example.course0.filtering

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FilteringController{

    @GetMapping("/student")

    fun getDetail() = Student(1, "ravi", 23)

}

@JsonIgnoreProperties("id", "age")
data class Student(@get:JsonIgnore val id: Long, val name:String, val age:Int)
