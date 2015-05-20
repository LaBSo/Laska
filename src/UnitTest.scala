
import org.junit.Test
import org.junit.Assert._

/**
 * Some simple unit tests.
 */
class UnitTests {
  @Test def testK2T1() {
    val x = new Kaavat
    val C = 282000
    val C2 = 188000
    val r = 0.13
    val n = 6
    val ReturningYears = 10
    val InvestedYears = 6
    val benefits = x.PVBenefits(C, r, InvestedYears, ReturningYears)
    val costs = x.PVCosts(C2, r, n)
    val NPV = benefits - costs
    val IRR = x.IRR(C, r, InvestedYears, ReturningYears, C2, n)

    /*Results
  println("Cost is " + x.formatter.format(costs))
  println("Benefits is " + x.formatter.format(benefits))
  println( "NPV is " +x.formatter.format(NPV))
  println( "IRR is " +"%.4f".format(IRR*100) + "%")
  */
  }
  @Test def testK2T2() {
    val x = new Kaavat
    val C = 15.0
    val AR = 24.0
    val I = 13.0
    val AP = 35.0
    val NWC = x.NWK(C, AR, I, AP)
    
    //println("Net working capital is " + x.formatter.format(NWC))
  }
  @Test def testK2T3() {
   
    val x = new Kaavat
    val Sales = 162.5
    val COGS = 55.7
    val Depriciation = 32.6
    val Tax = 1- 0.39
    val Expenditures = 42.6
    val IWC = 7.2
    val NI = x.NetIncome(Sales, COGS, Depriciation, Tax) 
    val FC = x.FreeCashFlow(NI,Depriciation, Expenditures, IWC)
//    println("Free Cash Flow is " + "%.4f".format(FC))
//    println("Net income is " + "%.4f".format(NI))  
  }
   @Test def testK2T4() {
   
    val x = new Kaavat
    val z =  List[Double](-161000.0,10000.0,93000.0,195000.0)
    val FCF = z.last
    val r = 0.12
    val g = 0.04
    val CV = x.ContinuationValue(FCF, r, g)
    val NPV = x.NPVc(z, r, CV)
    println("CV  is " + x.formatter.format(CV))
    println("NPV  is " + x.formatter.format(NPV))
   }
}
