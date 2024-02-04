package io.github.vootelerotov

import com.spotify.githubclient.shade.okhttp3.OkHttpClient
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.javaGetter

class KotlinIssueWithShadedOkHttpClientTest {

  @Test
  fun dispatcherShouldBeAccessible() {
    assertDoesNotThrow { OkHttpClient().dispatcher }
  }

  @Test
  fun reflectivelyAccesingPropertyShouldExposeJavaMethod() {
    val dispatcherProperty = OkHttpClient::class.memberProperties.first { it.name == "dispatcher" }
    assertDoesNotThrow { dispatcherProperty.javaGetter }
  }

  @Test
  fun kotlinCompilerDoesNotAllowOneToUseDispatcherMethodDirectly() {
    // assertDoesNotThrow { OkHttpClient().dispatcher() }
  }

}
