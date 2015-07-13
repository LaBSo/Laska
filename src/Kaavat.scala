class Kaavat {
  
  val formatter = java.text.NumberFormat.getIntegerInstance
  //Annuity formula FV = FutureValue, C = annual savings, r = rate of interest /year, n = number of years
  //val y = x.FV(7500,0.09,31)
  def FVa(C: Double, r: Double, n: Double):Double = (C * (1 / r) * (Math.pow((1 + r), n) - 1))
  
  //Counting annual withdrawal PV = present value, r = rate of interest /year (0.xx), n = number of years
  def PMT(PV: Double, r: Double, n: Double):Double =  PV / ((1 / r) * (1 - (1 / (Math.pow((1 + r), n)))))
  
  //NetPresentValue NPV = PresentValue(Benefits-Costs)
  //Present Value C= capital, r = is the cost of capital ,n = number of years
  def PVCosts(C: Double, r: Double, n: Double):Double = (C * (1 / r) * ((1-(1/Math.pow((1 + r), n) ))))
  
  //PVBenefits = Revenue - Cost of Investment
  def PVBenefits(C: Double, r: Double, InvestedYears: Double, ReturningYears: Double):Double = (1/Math.pow((1 + r),InvestedYears)*PVCosts(C, r, ReturningYears))
  
  //Internal rate of return
  def IRR(C: Double, r: Double, InvestedYears: Double, ReturningYears: Double,C2: Double,  n: Double):Double ={
    var r = 0.00001
    while (r < 1){
        var x = PVBenefits(C, r, InvestedYears, ReturningYears)- PVCosts(C2, r, n)
        if(x <= 0) return r
        r += 0.00001
    }
    return 0.0
  }
  //Net Working Capital  = Cash + Accounts Receivable + Inventory - Accounts Payable
  def NWK(C:Double,AR:Double,I:Double,AP:Double) = C+AR+I-AP
  
  //Incremental Earning Forecast
//  Sales (Revenues)
//  - Cost of Goods Sold and Operating Expenses
//  - Depreciatin (Arvonaleneminen/poistot)
//  ------
//  Earnings before interest and taxes (EBIT)
//  - Income taxes
//  ------
//  Net Income
  def NetIncome(Sales:Double,COGS:Double,Deprication:Double, Tax:Double):Double = (Sales - COGS -Deprication)*Tax

//Free Cash Flow
//  Net Income
//  Depreciation
//  - Capital expenditures
//  - Increases in Net Working Capital
  def FreeCashFlow (netIncome:Double, Depriciation:Double, Expenditures:Double, IWC:Double) = (netIncome + Depriciation) - (Expenditures +IWC)
  
// Continuation value (Present Value) = FreeCashFlow/ (r-g)
//r =   interest rate, g = growth rate
  def ContinuationValue (FCF:Double,r:Double,g:Double):Double= (FCF*(1+g))/(r-g)
  
  def NPV(Years:List[Double],r:Double,CV:Double, StartingYear:Double):Double = {
   var t = StartingYear
    var NPV = 0.0
    for (x<-Years){
      t+=1
      if (t > 0)NPV += (x/Math.pow((1+r),t))
      else NPV +=x      
    }
    //With Continuationvalue
    NPV+=(CV/Math.pow((1+r),t))
    NPV
  }
  def NPVc(Years:List[Double],r:Double,CV:Double):Double =NPV(Years, r, CV, 0)
  //CashValue = Cash + NPV of projects
  def CashValue (NPV:Double, Cash:Double):Double = NPV + Cash
  //Dividend yield = Div/P ;Div = Dividend, P = current price
  def DividendYieldProsent(Div:Double, P:Double):Double  = (Div/P)*100 
  //Capital gain rate = (P1 - P0) / P0; P0 = current price, P1 = new market price
  def CapitalGainRate(P0:Double, P1:Double):Double = ((P1 - P0) / P0)*100
  //Equity cost of capital = Dividend yield + Capital gain rate
  def ECC (Div:Double, gain:Double):Double = Div + gain
  // PresentValue for stock with Dividend
  def PresentValue(P:Double, Div:List[Double], r :Double):Double = {
    var result = 0.00
    var div = Div
    for (x <- 1 to Div.length ){
      if (div.length > 1)result += div.head/(Math.pow((1+r),x))
      else {
        result += (div.head + P)/(Math.pow((1+r),x))}
     div =  div.tail
     
    }
    result
  }
  //FCF free cash flow by year, r = cost of capital, g = industry growth rate
  def enterpriseValue(FCF:List[Double],r:Double,g:Double):Double ={
   val V0= PresentValue(0, FCF, r)+(FCF.last*(1 + g))/(Math.pow((1+r), FCF.length)*(r-g))
   return V0
  }
  def enterpriseValueStock(MarketValue:Double, Debt:Double, Cash: Double) = MarketValue + Debt - Cash
  def sharePrice(V0:Double, Cash: Double, Debt:Double, SharesOutstanding:Double):Double ={
    val P0 = (V0+Cash - Debt)/SharesOutstanding
    return P0
  }
  def marketValue(SharesOutstanding: Double, price: Double):Double = SharesOutstanding*price
  //Constant Dividend growth model P0 = Div1/(r-g), r = cost of capital, g = dividend growth rate
  def constantDividendSharePrice (Div1: Double, r:Double,g:Double):Double =  Div1/(r-g)
  //Constant Dividend growth model P0 = Div1/(r-g), g = r - Div1/P0
  def constantDividendGrowthRate (r:Double,Div1:Double,P0:Double):Double = r - Div1/P0
  //Unlevered
  def marketValueProbability (Value:List[Double],Prob:List[Double]):Double = (Value zip Prob).map(x => x._1 * x._2).sum
  // Current value of debt = Debt /(1 + Risk free rate%)
  def currentValueDebt(Debt:Double, riskFree:Double):Double = Debt/(1+riskFree)
  
  def currentValueLeveredEquity(UnleveredEquity:Double,Debt:Double):Double = UnleveredEquity-Debt
  
  def expectedReturn(Equity:Double, ExpectedEquity:Double):Double = (ExpectedEquity/Equity)-1 
  
  def realizedReturn(MarketValue:Double, Equity:Double) = (MarketValue/Equity) -1
}
 