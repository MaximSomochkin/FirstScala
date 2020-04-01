package myExamp

object Recursion extends App {

  @scala.annotation.tailrec
  def dcd(x: Long, y: Long): Long =
    if (y == 0) x else dcd(y, x % y)
}
