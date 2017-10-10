package com.pattern.builder.example001;

public class TestBuilder {
    public static void main(String[] args) {
        Computer computer = null;
        ComputerDirector director = null;
        director=new ComputerDirector(new MacBuilder());
        computer = director.construct();
        System.out.println(computer);

        director=new ComputerDirector(new NoteBookBuilder());
        computer = director.construct();
        System.out.println(computer);

        director=new ComputerDirector(new PCBuilder());
        computer = director.construct();
        System.out.println(computer);
    }
}
