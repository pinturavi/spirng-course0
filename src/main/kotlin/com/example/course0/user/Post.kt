package com.example.course0.user

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@JsonIgnoreProperties("user")
data class Post(
        @Id
        @GeneratedValue
        var id: Long = 0,

        var description: String,

        @ManyToOne(fetch = FetchType.LAZY)
        var user:User?=null
)