package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .setDatabaseUrl(dbUrl)
        .build()

    FirebaseApp.initializeApp(options)
    val message = Message.builder()
        .putData("action", "Lie")
        .putData("content", """{
            "userId": 1,
            "userName": "admin",
            "postId": 2,
            "postAuthor": "Netology"
            }
        """.trimMargin())
        .setToken(token)
        .build()
    val response = FirebaseMessaging.getInstance().send(message)
    println("Successfully sent message: $response")
}