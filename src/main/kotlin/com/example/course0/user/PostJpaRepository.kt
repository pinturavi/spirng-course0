package com.example.course0.user

import org.springframework.data.jpa.repository.JpaRepository

interface PostJpaRepository:JpaRepository<Post, Long>