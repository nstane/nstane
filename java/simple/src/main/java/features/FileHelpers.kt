package features

import java.io.File
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

fun main(arg: Array<String>) {
    println("File utils")
    //https://grokonez.com/spring-framework/spring-boot/kotlin-spring-boot/kotlin-springboot-upload-download-file-multipartfile-thymeleaf-bootstrap-4

    File("data.text").writeText("Test content", StandardCharsets.UTF_8)

    File("/Users/natanwar/Computer/git/simple/data.text").inputStream().let {
        val bytes = ByteArray(16)
        it.read(bytes)
        it.close()
        println(String(bytes, StandardCharsets.UTF_8))
    }
}
