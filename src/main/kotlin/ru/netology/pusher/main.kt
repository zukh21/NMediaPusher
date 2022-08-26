package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

fun main() {
    val topic = "/topics/FOOTBALL"
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .setDatabaseUrl(dbUrl)
        .build()

    FirebaseApp.initializeApp(options)

// See documentation on defining a message payload.

// See documentation on defining a message payload.
    val message = Message.builder()
        .putData("action", "Like")
        .putData("content", """{
            "userId": 1,
            "userName": "admin",
            "postId": 2,
            "postAuthor": "Netology"
            }
        """.trimMargin())
        .setToken(token)
        .build()

// Send a message to the devices subscribed to the provided topic.

// Send a message to the devices subscribed to the provided topic.
    val response = FirebaseMessaging.getInstance().send(message)
// Response is a message ID string.
// Response is a message ID string.
    println("Successfully sent message: $response")
}