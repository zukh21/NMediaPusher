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

    val message = Message.builder()
        .putData("post", """{
            "id": 1,
            "author": "Netology",
            "content": "this is content this is content this is content this is content this is content this is content this is content this is content this this is content is content",
            "publishedDate": "now",
            "videoLink": "https://image.winudf.com/v2/image/Y29tLmZydWl0d2FsbHBhcGVyLmhkLmZydWl0cGljdHVyZXMucGhvdG9zLmJhY2tncm91bmQuY3V0ZS5jb29sLmFydC5mcnVpdGltYWdlcy5oZC5mcmVlX3NjcmVlbl8wXzE1MzIwODEwMzdfMDY0/screen-0.jpg?fakeurl=1&type=.jpg"
            }
        """.trimMargin())
        .setTopic(topic)
        .build()
    val response = FirebaseMessaging.getInstance().send(message)
    println("Successfully sent message: $response")
}