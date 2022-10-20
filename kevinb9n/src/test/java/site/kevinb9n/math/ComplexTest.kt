package site.kevinb9n.math

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import site.kevinb9n.javafx.random
import kotlin.math.PI
import kotlin.math.abs

class ComplexTest {
  @Test
  fun standard() {
    for (i in 1..100_000) {
      val a = Complex(random(5.0), random(5.0))
      val b = Complex(random(5.0), random(5.0))
      checkEverything(a, b)
    }
  }

  @Test
  fun polar() {
    for (i in 1..100_000) {
      val a = Complex.fromPolar(abs(random(5.0)), random(PI))
      val b = Complex.fromPolar(abs(random(5.0)), random(PI))
      checkEverything(a, b)
      checkEverything(a, b.re)
    }
  }

  private fun checkEverything(a: Complex, b: Complex) {
    checkEqual(a * 1, a)
    checkEqual(a / 1, a)
    checkEqual(-a, a * -1)
    checkEqual(a + a, a * 2)
    checkEqual(a + a - a, a)
    checkEqual(a - a + a, a)
    checkEqual(a + b, b + a)
    checkEqual(a + b, b + a)
    checkEqual(a * b, b * a)
    checkEqual(a / a, Complex(1.0, 0.0))
    checkEqual(a * b / b, a)
    checkEqual(a * b / a, b)
    checkEqual(a, a * 274 - a * 273)
    checkEqual(a / 5.0, a * 0.2)
    checkEqual(a + (b + a), (a + b) + a)
    checkEqual(a * (b + a), a * b + a * a)
    checkEqual(a.pow(0.4) * a.pow(0.6), a)
    checkEqual(a.pow(1.3) / a.pow(0.3), a)
  }

  private fun checkEverything(a: Complex, b: Number) {
    checkEqual(a * b / b, a)
    checkEqual(a * b / a, Complex(b.toDouble(), 0.0))
    checkEqual(a + (a + b), (a + b) + a)
    checkEqual(a * (a + b), a * a + a * b)
  }

  private fun checkEqual(a: Complex, b: Complex) {
    val tolerance = 1e-9
    try {
      assertThat(a.abs()).isWithin(tolerance).of(b.abs())
      assertThat(a.theta()).isWithin(tolerance).of(b.theta())
    } catch (e: Error) {
      assertThat(a.re).isWithin(tolerance).of(b.re)
      assertThat(a.im).isWithin(tolerance).of(b.im)
    }
  }
}
