import com.typesafe.scalalogging.StrictLogging

trait Config:
  val timeout = 5000
  val workers = 128

trait Timer:
  def measure[A](name: String)(block: => A): A =
    val start = System.nanoTime()
    val result = block
    val elapsed = (System.nanoTime() - start) / 1_000_000
    println(s"$name took ${elapsed}ms")
    result

object Scanner extends Config, Timer, StrictLogging:
  def scan(ip: String): Unit =
    measure(s"Scanning $ip") {
      logger.info(s"Scanning $ip")
      Thread.sleep(100)
      logger.info(s"Finished $ip")
    }

@main def run(): Unit =
  Scanner.scan("192.168.1.1.")
