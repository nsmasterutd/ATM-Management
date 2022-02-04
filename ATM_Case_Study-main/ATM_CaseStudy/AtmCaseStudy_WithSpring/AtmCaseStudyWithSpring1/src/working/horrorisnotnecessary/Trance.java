package working.horrorisnotnecessary;

public class Trance {
int AccountNO;
int amount;
String type;
String tdate;

public Trance() {
	// TODO Auto-generated constructor stub
}
public int getAccountNO() {
	return AccountNO;
}
public int getAmount() {
	return amount;
}
public String getType() {
	return type;
}
public String getTdate() {
	return tdate;
}
public void setAccountNO(int accountNO) {
	AccountNO = accountNO;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public void setType(String type) {
	this.type = type;
}
public void setTdate(String tdate) {
	this.tdate = tdate;
}
@Override
public String toString() {
	return "Trance [AccountNO=" + AccountNO + ", amount=" + amount + ", type=" + type + ", tdate=" + tdate + "]";
}
}
