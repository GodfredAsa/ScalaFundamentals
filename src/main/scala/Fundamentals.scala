import BankingApp.Customer

import java.io.{File, PrintWriter}
import scala.io.StdIn.readLine
import scala.io.Source
import scala.util.matching.Regex.Match
object Fundamentals extends App{

//  Recursive function
//  println(buildList())

//  println(stringConcateBypattern(buildList()))


def buildList(): List[String] = {
  print("Enter words: ")
  val input = readLine()
  if(input =="quit") Nil else input::buildList()
}

  def stringConcateBypattern(words: List[String]): String = words match{
    case Nil => ""
    case h::t => h + " "+  stringConcateBypattern(t)
  }

  /**
   *Write a function that takes an operator that performs operation based on the operator
   */
  def calc(operator: String, a: Int, b: Int): Unit  = operator match{
    case "add" => println(a + b)
    case "subtract" => println(a-b)
    case "multiply" => println(a*b)
    case "divide" => println(a/b)
  }

calc("add", 2,3)



//  Reading Files
  val source = Source.fromFile("src/main/index.txt")
  val lines = source.getLines()
 val matrix = lines.map(_.split(" ").map(_.toDouble)).toArray
  source.close()

//  Writing to another file
  val pw = new PrintWriter("rowSums.txt")

  matrix.foreach(row=>pw.println(row.sum))
  pw.close()



// function within another function, Anonymous function
  val multBy = (n: Int) => ((x: Int) => x*n)
  val double = multBy(2)
  val mine = double(4)

  println( "results: "+ mine)

  val num = (n: Int) => ((x: Int) => (y: Int)=> x*y*n)

  val u = num(1)
  val ux = u(10)
  val uxy = ux(3)

  println(uxy)

//  Function Composition
//  val f = (x: Int) => x + 2
//  val g = (x: Int) => x + 10
//  val results = f compose g
//
//  println("Answer: "+ results)
//
//// Collections working with maps and filter
//
//  val range1  = 1 until 10
//  range1.foreach(i=>print(" " + i))
//  range1.map(s=> s + 10).filter(f=> f<20).toArray.foreach(i=>println(" " + i))
//
//// Sequence and Zipping in scala
//  val scores = Seq(20, 40, 45, 60, 0)
//  val students = Seq("A", "B", "C", "D", "E")
//  println(scores.zip(students))
//
//
////
//  val squares = for(a <- 1 to 5) yield a * a // Vector(1, 4, 9, 16, 25)
//  println(squares)
//
//// Yield all odd numbers from 1 to 20
//  val squareOddNumbers  = for(c <- 1 to 20  if(c %2 != 0))  yield c // Vector(1, 3, 5, 7, 9, 11, 13, 15, 17, 19)
//  println(squareOddNumbers)



  val westAfrica = Map("GHA"->"Ghana", "NIG"->"Nigeria","TOG"->"Togo", "CDV"->"La Cote D'Voire")
  println(westAfrica.values)


// CHECKING DIRECTORY AND FILES
  var direct = (new java.io.File(".")).listFiles()
  def directory(): Unit = {

    println("List of Directories ")
    var listOfDirectories = direct.filter(s=> !(s.getName.startsWith(".")) && s.isDirectory).toList
    println(listOfDirectories)

    var listOfFiles = direct.filter(s=> !(s.getName.startsWith(".")) && s.isFile).toList

    println("Sorting Files By their Sizes")
    var fileSize = listOfFiles
      .map(s=>(s.getName, s.length()))
      .sortBy(t=>t._2)
      .toList

    println("comparing Files and Directories By Length and Sorting By Size")
    var compaireFiles = direct
      .map(f=>(f.getName, f.length()))
      .sortBy(_._2).toList

    println(compaireFiles)
    println(fileSize)

    println("List of Files ")
    println(listOfFiles)

  }

  directory()



//

  val cust1 = new Customer("Fred", "Box Nt 456","Savings", "02444155684", 20.0)


println("*"*100)
println("Actions to Perform:\n-report\n-balance\n-deposit\n-withdraw\nquit")
  println("*"*100)
  val quit = false
while(!quit){
  print("Make an Option: ")
  val yor =  readLine()
  if(yor =="report")
    println(cust1)
  else if(yor=="deposit"){
    print("Make a Deposit: ")
    val  deposit= readLine()
    cust1.deposit(deposit.toDouble)
  }

  else if(yor=="withdraw"){
    print("Make a Withdrawal: ")
    val  withdraw= readLine()
    cust1.withdrawal(withdraw.toDouble)
  }

  else if(yor=="balance"){
    println(cust1.balance)
  }



}

}
