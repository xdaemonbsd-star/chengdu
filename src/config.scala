import java.nio.file.Files
import java.nio.file.Path

trait ConfigScanner {
  def Scan(path: Path): Unit
  def 
}

class MockScanConfig extends ConfigScanner {
  def readToScanTxtFile() =
    val path = Path.of("toscan.txt")
    val readLinesOfScanTxt = Files.readAllLines(path)
    val filterLineStartsWithHasbang = readLinesOfScanTxt
      .stream()
      .filter(line => line.startsWith("#"))
      .toList()
    
}
