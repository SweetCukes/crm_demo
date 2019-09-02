package vo;

public class Datas {
 private int num;
 private String title;
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
@Override
public String toString() {
	return "Datas [num=" + num + ", title=" + title + "]";
}
}
