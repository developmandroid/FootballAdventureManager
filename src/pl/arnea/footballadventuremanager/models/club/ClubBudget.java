package pl.arnea.footballadventuremanager.models.club;

public class ClubBudget {
    int income;
    int outcome;

    int incomeThisSeason;
    int outcomeThisSeason;

    int incomeLastSeason;
    int outcomeLastSeason;

    int incomeThisMonth;
    int outcomeThisMonth;

    int incomeLastMonth;
    int outcomeLastMonth;

    public ClubBudget(int income, int outcome, int incomeThisSeason,
                      int outcomeThisSeason, int incomeLastSeason, int outcomeLastSeason,
                      int incomeThisMonth, int outcomeThisMonth, int incomeLastMonth,
                      int outcomeLastMonth) {
        this.income = income;
        this.outcome = outcome;
        this.incomeThisSeason = incomeThisSeason;
        this.outcomeThisSeason = outcomeThisSeason;
        this.incomeLastSeason = incomeLastSeason;
        this.outcomeLastSeason = outcomeLastSeason;
        this.incomeThisMonth = incomeThisMonth;
        this.outcomeThisMonth = outcomeThisMonth;
        this.incomeLastMonth = incomeLastMonth;
        this.outcomeLastMonth = outcomeLastMonth;
    }


    public int getIncomeThisSeason() {
        return incomeThisSeason;
    }

    public void setIncomeThisSeason(int incomeThisSeason) {
        this.incomeThisSeason = incomeThisSeason;
    }


    public int getIncome() {
        return income;
    }


    public void setIncome(int income) {
        this.income = income;
    }


    public int getOutcome() {
        return outcome;
    }


    public void setOutcome(int outcome) {
        this.outcome = outcome;
    }


    public int getOutcomeThisSeason() {
        return outcomeThisSeason;
    }


    public void setOutcomeThisSeason(int outcomeThisSeason) {
        this.outcomeThisSeason = outcomeThisSeason;
    }


    public int getIncomeLastSeason() {
        return incomeLastSeason;
    }


    public void setIncomeLastSeason(int incomeLastSeason) {
        this.incomeLastSeason = incomeLastSeason;
    }


    public int getOutcomeLastSeason() {
        return outcomeLastSeason;
    }


    public void setOutcomeLastSeason(int outcomeLastSeason) {
        this.outcomeLastSeason = outcomeLastSeason;
    }


    public int getIncomeThisMonth() {
        return incomeThisMonth;
    }


    public void setIncomeThisMonth(int incomeThisMonth) {
        this.incomeThisMonth = incomeThisMonth;
    }


    public int getOutcomeThisMonth() {
        return outcomeThisMonth;
    }


    public void setOutcomeThisMonth(int outcomeThisMonth) {
        this.outcomeThisMonth = outcomeThisMonth;
    }


    public int getIncomeLastMonth() {
        return incomeLastMonth;
    }


    public void setIncomeLastMonth(int incomeLastMonth) {
        this.incomeLastMonth = incomeLastMonth;
    }


    public int getOutcomeLastMonth() {
        return outcomeLastMonth;
    }


    public void setOutcomeLastMonth(int outcomeLastMonth) {
        this.outcomeLastMonth = outcomeLastMonth;
    }


}
