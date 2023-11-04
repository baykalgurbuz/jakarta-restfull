package jakartarest.model;

public class Ogrenci {
 private long ID;
 private String NAME;
 private long OGRENCI_NUMBER;
 private long YEAR;
public long getID() {
	return ID;
}
public void setID(long iD) {
	ID = iD;
}
public Ogrenci(String nAME, long oGRENCI_NUMBER, long yEAR) {
	super();
	NAME = nAME;
	OGRENCI_NUMBER = oGRENCI_NUMBER;
	YEAR = yEAR;
}
public Ogrenci() { 
}
@Override
public String toString() {
	return "Ogrenci [ID=" + ID + ", NAME=" + NAME + ", OGRENCI_NUMBER=" + OGRENCI_NUMBER + ", YEAR=" + YEAR + "]";
}
public Ogrenci(long iD, String nAME, long oGRENCI_NUMBER, long yEAR) { 
	ID = iD;
	NAME = nAME;
	OGRENCI_NUMBER = oGRENCI_NUMBER;
	YEAR = yEAR;
}
public String getNAME() {
	return NAME;
}
public void setNAME(String nAME) {
	NAME = nAME;
}
public long getOGRENCI_NUMBER() {
	return OGRENCI_NUMBER;
}
public void setOGRENCI_NUMBER(long oGRENCI_NUMBER) {
	OGRENCI_NUMBER = oGRENCI_NUMBER;
}
public long getYEAR() {
	return YEAR;
}
public void setYEAR(long yEAR) {
	YEAR = yEAR;
}
}
