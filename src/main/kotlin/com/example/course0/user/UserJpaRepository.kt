package com.example.course0.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository:JpaRepository<User, Long> {
}