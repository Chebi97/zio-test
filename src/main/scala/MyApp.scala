import zio._
import zio.Console.{printLine, readLine}

import java.io.IOException
import scala.io.{BufferedSource, Source}

object MyApp extends ZIOAppDefault {

  val writeToConsole: IO[IOException, Unit] = printLine("Hola")

  val readFromConsole: ZIO[Any, IOException, Unit] = readLine.map("this was the input:" + _).map(println(_))

  val chained: IO[IOException, Unit] = readLine.flatMap(printLine(_))

  val forComp = for {
    str <- readLine
    _ <- printLine(str)
  } yield ()

  val s1 = ZIO.succeed("42")
  val n1 = ZIO.succeed(43)

  val zipSeq = s1.zip(n1).map(println)

  val zipLeft = printLine("name?") <* readLine
  val zipRight = readLine *> printLine("name?")

  val zEither: URIO[Any, Either[String, Nothing]] = ZIO.fail("failed").either

//  val fileReader: IO[Throwable, BufferedSource] = {
//    IO(Source.fromFile("file1.txt"))
//  }

  def run = zipRight


}