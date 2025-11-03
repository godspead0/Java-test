package javaProgramming.demo5;

public class LeapYear {
    public boolean getLeapYear(int year){
        if(year%4==0&&year%100!=0||year%400==0){
            return true;
        }else {
            return false;
        }
    }
}
