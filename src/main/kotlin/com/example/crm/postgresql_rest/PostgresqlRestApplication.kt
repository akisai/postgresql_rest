package com.example.crm.postgresql_rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PostgresqlRestApplication

fun main(args: Array<String>) {
    runApplication<PostgresqlRestApplication>(*args)
}