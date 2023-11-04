package jakartarest.model;

public class Konu {
 private long ID;
 private String NAME;
public Konu(long iD, String nAME) {
	super();
	ID = iD;
	NAME = nAME;
}
public Konu(String nAME) {
	super();
	NAME = nAME;
}
public Konu() {
	super();
}
public long getID() {
	return ID;
}
public void setID(long iD) {
	ID = iD;
}
public String getNAME() {
	return NAME;
}
public void setNAME(String nAME) {
	NAME = nAME;
}
@Override
public String toString() {
	return "Konu [ID=" + ID + ", NAME=" + NAME + "]";
}
}
