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
       println("Present value is " + "%.4f".format(presentValue))  
       println("Levered equity " + "%.4f".format(levered))  
       println("Expected return is unlevered " + "%.4f".format(return1))  
       println("Expected return is  levered " + "%.4f".format(return2))  
       println("Min rezlized return is  unlevered " + "%.4f".format(return3))  
       println("Min rezlized return is  levered " + "%.4f".format(return4))  
  }
  @Test def testK4T2() {
    val x = new Kaavat
  }
}