package com.example.course0.user

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.validation.constraints.Past
import javax.validation.constraints.Size

@ApiModel("All details about the user")
@Entity
data class User(@Id @GeneratedValue var id:Int=0, @get:Size(min=2, message = "name should have atleast 2 characters") @get:ApiModelProperty("name should have atleast two characters.")var name:String, @get:Past( message = "Date of Birth should be in past.") @get:ApiModelProperty("Birth date should be before current time.") var dob:LocalDate, @OneToMany(targetEntity = User::class) var posts:List<Post> = listOf())
