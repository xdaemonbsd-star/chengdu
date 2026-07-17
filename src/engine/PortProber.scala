import java.nio.file.{Files, Path}
import java.io.IOException

object Logger:
  private val dir = Path.of("log")

  if !Files.exists(dir) then
    try Files.createDirectories(dir)
    catch
      case e: IOException =>
        throw new RuntimeException("Failed to create log directory", e)
