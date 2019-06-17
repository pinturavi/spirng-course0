package com.example.course0.user

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI
import java.time.LocalDate

@Service
class UserService(val ur:UserJpaRepository) {

    companion object {
        var users: List<User> = listOf(
                User(1, "ravi", LocalDate.of(2000, 12, 5)),
                User(2, "pintu", LocalDate.of(1996, 3, 15))
        )
    }

    fun findAll() = users

    fun findOne(id: Int):User{
        val user: User? = users.find { it.id == id }
        //val user = ur.findById(id)
        if (user != null)
            return user
        else {
            throw UserNotFoundException("user not available")
        }
    }

    fun removeOne(id: Int) {
        val user: User? = users.find { it.id == id }
        if (null != user)
            users = users.minusElement(user)
        else {
            throw UserNotFoundException("user not available")
        }
    }

    fun addUser(user: User): ResponseEntity<User> {
        users += user
        val location: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.id).toUri()
        return ResponseEntity.created(location).build<User>()
    }

    fun findAllPosts(id:Int): List<Post> {
        val user:User? = users.find { it.id == id }
        if(null != user)
            return user.posts
        else {
            throw UserNotFoundException("user not available.")
        }
    }

    fun addPost(id: Int, post: Post) {
        val user:User? = users.find { it.id == id }
        if(null != user)
            user.posts += post
        else
            throw UserNotFoundException("user not available.")
    }

    fun findPostbyId(id: Int, postId: Int): Post? {
        val user:User? = users.find { it.id == id }
        if(null != user) {
            val post: Post? = user.posts.find { it.id == postId }
            if (null != post) {
                return post
            } else {
                throw UserNotFoundException("post not available.")
            }
        }
        else
            throw UserNotFoundException("user not available.")
    }
}