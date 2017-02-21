package io.scalajs.npm.streamthrottle

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Throttle Options
  * @param rate      is the throttling rate, in bytes per second.
  * @param chunksize (optional) is the maximum chunk size into which larger writes are decomposed;
  *                  the default is opts.rate/10.
  */
@ScalaJSDefined
class ThrottleOptions(val rate: Double,
                      val chunksize: js.UndefOr[Double] = js.undefined)
  extends js.Object