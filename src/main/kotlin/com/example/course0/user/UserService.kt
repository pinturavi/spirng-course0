package com.example.course0.user

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@Service
class UserService(val ur: UserJpaRepository, val pr: PostJpaRepository) {

    fun findAll(): MutableList<User> = ur.findAll()

    fun findOne(id: Long): User {
        return ur.findById(id).map {
            it
        }.orElseThrow { UserNotFoundException("user not available") }

    }

    fun removeOne(id: Long) = ur.deleteById(id)

    fun addUser(user: User): ResponseEntity<User> {
        ur.save(user)
        val location: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.id).toUri()
        return ResponseEntity.created(location).build<User>()
    }

    fun findAllPosts(id: Long): List<Post> {
        return ur.findById(id).map {
            it.posts
        }.orElseThrow { UserNotFoundException("user not available.") }
    }

    fun addPost(id: Long, post: Post): Post {
        return ur.findById(id).map {
            post.user = it
            pr.save(post)
        }.orElseThrow { UserNotFoundException("user not available") }
    }

    fun findPostbyId(id: Long, postId: Long): Post? {
        return ur.findById(id).map {
            it.posts.find { post -> post.id == postId }
        }.orElseThrow { UserNotFoundException("user not available") }
    }
}