package edu.umb.cs681.hw16;


public interface FSVisitor {
	void visit (Link lk);
    void visit (Directory dir);
    void visit (File fl);
}
