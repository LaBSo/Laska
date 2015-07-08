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
//  println("Yield is " + "%.4f".format((DivY)) + "%")
//  println("Gain is " + "%.4f".format((gain)) + "%")
//  println("ECC is " + "%.4f".format(ECC) + "%")
  }
    @Test def testK3T2() {
  val x = new Kaavat
  val P = 51.36
  val r = 0.083
  val Div = List(2.76)
  val res = x.PresentValue(P, Div, r)
//  println("Value is " + "%.4f".format(res) )
  
  }
  @Test def testK3T3() {
  //Estimate enterprise value
  val x = new Kaavat
  val FCF =List(52.5,68.5,76.7,75.7,80.3) 
  val g =0.035
  val r = 0.137
  val Cash = 0
  val Debt = 307
  val SharesOutstanding = 39
  val res = x.enterpriseValue(FCF, r, g)
  val res2 = x.sharePrice(res, Cash, Debt, SharesOutstanding)
//  println("Enterprise Value is " + "%.4f".format(res) )
//  println("Share Value is " + "%.4f".format(res2) )
  
  }
    @Test def testK3T4() {
  //Estimate enterprise value
  val x = new Kaavat
  val FCF =List(0.0) 
  val Sales = 483.0
  val taxRate =0.4
  val wacc = 0.108
  val Cash = 45.3
  val Debt = 0.0
  val price = 14.99
  val SharesOutstanding = 18.3
  val res = x.enterpriseValueStock(x.marketValue(SharesOutstanding, price), Debt, Cash)  
  val res2 = res*wacc
  val EBIT = res2/(1-taxRate)
  val EBITmargin = EBIT/Sales
  println("FCF is " + "%.4f".format(res2) )
  println("EBIT is " + "%.4f".format(EBIT) )
  println("EBIT margin is " + "%.4f".format(EBITmargin) )
  
  }
  
}