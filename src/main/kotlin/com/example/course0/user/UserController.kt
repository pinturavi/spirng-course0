package com.example.course0.user

import org.springframework.hateoas.Resource
import org.springframework.web.bind.annotation.*
import org.springframework.hateoas.mvc.ControllerLinkBuilder.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/users")
class UserController(val userService: UserService) {

    @GetMapping
    fun getUsers() = userService.findAll()

    @GetMapping("/{id}")
    fun getUser(@PathVariable("id") id: Int): Resource<User?> {
        val user = userService.findOne(id)
        val resource:Resource<User?>  = Resource(user)
        val link = linkTo(methodOn(this.javaClass).getUsers()).withRel("all-users")
        resource.add(link)
       return  resource
    }

    @PostMapping
    fun addUser(@Valid @RequestBody user: User) = userService.addUser(user)

    @DeleteMapping("/{id}")
    fun removeUser(@PathVariable("id") id: Int) = userService.removeOne(id)

    @GetMapping("/{id}/posts")
    fun getAllPosts(@PathVariable("id") id: Int) = userService.findAllPosts(id)

    @GetMapping("/{id}/posts/{post_id}")
    fun findPostById(@PathVariable("id")id:Int, @PathVariable("post_id") postId:Int) = userService.findPostbyId(id, postId)

    @PutMapping("/{id}/posts")
    fun addPost(@PathVariable("id") id:Int, @RequestBody post: Post) = userService.addPost(id, post)

}