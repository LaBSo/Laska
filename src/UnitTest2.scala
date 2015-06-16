import org.junit.Test
import org.junit.Assert._

class UnitTest2 {
  @Test def testK3T1() {
  val x = new Kaavat
  val P0 = 14
  val P1 = 31
  val Div = 1
  val DivY = x.DividendYieldProsent(Div, P0)
  val gain = x.CapitalGainRate(P0, P1)
  val ECC = x.ECC(DivY, gain)
  println("Yield is " + "%.4f".format((DivY)) + "%")
  println("Gain is " + "%.4f".format((gain)) + "%")
  println("ECC is " + "%.4f".format(ECC) + "%")
  }
  
}