import org.junit.Test
import org.junit.Assert._

class UnitTest3 {
 @Test def testK4T1() {

    val x = new Kaavat
    val Value = List(49.0,19.0)
    val Prob = List(0.90, 0.10)
    val r = 0.08
    val riskFree =  0.04
    val Debt =19
    val marketValue = x.marketValueProbability(Value, Prob)
    val presentValue = x.PVCosts(marketValue, r, 1)
    val currentValueDebt = x.currentValueDebt(Debt, riskFree)
    val levered = presentValue- currentValueDebt
    val return1 = x.expectedReturn(presentValue, marketValue)
    val return2 = x.expectedReturn(levered,(marketValue - Debt))
    val return3 = x.realizedReturn(Value.min, presentValue)
    val return4 = x.realizedReturn(Value.min - Debt, levered)
     //  println("Present value unlevered equity " + "%.4f".format(marketValue))
//       println("Present value is " + "%.4f".format(presentValue))  
//       println("Levered equity " + "%.4f".format(levered))  
//       println("Expected return is unlevered " + "%.4f".format(return1))  
//       println("Expected return is  levered " + "%.4f".format(return2))  
//       println("Min rezlized return is  unlevered " + "%.4f".format(return3))  
//       println("Min rezlized return is  levered " + "%.4f".format(return4))  
  }
  @Test def testK4T2() {
    val shares = 220.0
    val price = 10.31
    val short = 416.0
    val long = 388.0
    val issuing = 397.0
    val cash = 15.0
//    println("Cash " + "%.4f".format(cash))
//    println("Non cash assets " + "%.4f".format(shares*price - cash))
//     println("Total Assets " + "%.4f".format(shares*price))
//     println("Total Liabilities " + "%.4f".format(0.00000000))
//      println("Equity" + "%.4f".format(0.00000000))
  }
    @Test def testK4T3() {

    val x = new Kaavat()
    val VolatilyOfPortfolio = 0.10
    val Corr = 0.43
    val riskFree = 0.03
    val VolatilyOfAsset = 0.15
    val exp = 0.08
    val beta = x.beta(VolatilyOfPortfolio, Corr, VolatilyOfAsset)
    val expected = x.expectedReturn(beta, riskFree, exp)
      println("Beta is " + "%.4f".format(beta))
      println("Expected return is " + "%.4f".format(expected))
      println(4.98*0.21+0.29*10.68+6.23*0.50)
      println(0.40*0.21+0.29*1.54+0.65*0.50)
      print("Expected return is " + "%.4f".format(x.expectedReturn(0.85559, riskFree, exp)))
  }
}