package edu.umb.cs681.hw11;

public interface FSVisitor {
    void visit (Link lk);
    void visit (Directory dir);
    void visit (File fl);

}

