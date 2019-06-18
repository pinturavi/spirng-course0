package com.example.course0.user

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.validation.constraints.Past
import javax.validation.constraints.Size

@ApiModel("All details about the user")
@JsonIgnoreProperties("hibernateLazyInitializer", "handler")
@Entity
data class User(
        @Id
        @GeneratedValue
        var id: Long = 0,

        @get:Size(min = 2,message = "name should have atleast 2 characters")
        @get:ApiModelProperty("name should have atleast two characters.")
        var name: String,

        @get:Past(message = "Date of Birth should be in past.")
        @get:ApiModelProperty("Birth date should be before current time.")
        var dob: LocalDate,

        @OneToMany(mappedBy = "user")
        @Cascade(CascadeType.DELETE)
        var posts: List<Post> = listOf()
)
