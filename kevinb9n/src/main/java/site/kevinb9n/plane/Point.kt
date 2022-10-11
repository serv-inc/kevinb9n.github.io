package site.kevinb9n.plane

import site.kevinb9n.javafx.mean
import site.kevinb9n.plane.Vector.Companion.vector

data class Point(val x: Double, val y: Double) {

  constructor(x: Number, y: Number) : this(x.toDouble(), y.toDouble())

  operator fun plus(v: Vector) = Point(x + v.x, y + v.y)
  operator fun minus(p: Point) = vector(x - p.x, y - p.y)
  operator fun minus(v: Vector): Point = this + -v

  fun distance(other: Point) = (this - other).magnitude
  fun midpoint(pt2: Point) = Point(mean(x, pt2.x), mean(y, pt2.y)) // this + (pt2 - this) / 2.0

  companion object {
    val ORIGIN = Point(0, 0)
  }
}
