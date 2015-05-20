class Kaavat {
  
  val formatter = java.text.NumberFormat.getIntegerInstance
  //Annuity formula FV = FutureValue, C = annual savings, r = rate of interest /year, n = number of years
  //val y = x.FV(7500,0.09,31)
  def FV(C: Double, r: Double, n: Double):Double = (C * (1 / r) * (Math.pow((1 + r), n) - 1))
  
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
  
  
}