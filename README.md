stream-throttle package for Scala.js
================================
[stream-throttle](http://stream-throttle.github.io/node-stream-throttle-native/2.2/api/) - A rate limiter for Node.js streams.

### Description

A rate limiter for Node.js streams.

<a name="build_requirements"></a>
### Build Requirements

* [ScalaJs.io v0.3.x](https://github.com/scalajs-io/scalajs.io)
* [SBT v0.13.13](http://www.scala-sbt.org/download.html)

<a name="building_sdk"></a>
### Build/publish the SDK locally

```bash
 $ sbt clean publish-local
```

### Running the tests

Before running the tests the first time, you must ensure the npm packages are installed:

```bash
$ npm install
```

Then you can run the tests:

```bash
$ sbt test
```

### Examples

```scala
import io.scalajs.nodejs._
import io.scalajs.npm.streamthrottle._

process.stdin.pipe(new Throttle(new ThrottleOptions(rate = 10))).pipe(process.stdout)
```

```scala
import io.scalajs.nodejs._
import io.scalajs.nodejs.net._
import io.scalajs.npm.streamthrottle._
import scalajs.js

val tg = new ThrottleGroup(new ThrottleOptions(rate = 10240))

val conn1 = Net.createConnection(host = "www.google.com", port = 80)
val conn2 = Net.createConnection(host = "www.google.com", port = 80)

val thr1 = conn1.pipe(tg.throttle())
val thr2 = conn2.pipe(tg.throttle())

// Reads from thr1 and thr2 are throttled to 10 KB/s in aggregate
```

### Artifacts and Resolvers

To add the `stream-throttle` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "stream-throttle" % "0.1.3"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
