package com.example.course0.user

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity

data class Post(@Id @GeneratedValue var id:Int, var name:String)