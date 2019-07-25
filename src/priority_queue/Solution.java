package priority_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;


class Student {

    private int id;
    private String name;
    private double cgpa;
        
    public Student(int id, String name, double cgpa) {
        super();
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCgpa() {
        return cgpa;
    }
    
}

class Priorities {

    public List<Student> getStudents(List<String> events) {
        
        PriorityQueue<Student> queue = new PriorityQueue<>(
                Comparator.comparing(Student::getCgpa).reversed()
                .thenComparing(Student::getName)
                .thenComparing(Student::getId)
                );
        
        for (String event: events) {
            if (event.equals("SERVED") && !queue.isEmpty()) {
                queue.remove();
            } else {
                String[] eventSplitted = event.split(" ");
                if (eventSplitted[0].equals("ENTER")) {
                    Student newStudent = new Student(
                            Integer.parseInt(eventSplitted[3]), 
                            eventSplitted[1],
                            Double.parseDouble(eventSplitted[2])
                            );
                    queue.add(newStudent);
                }
            }
        }
        
        List<Student> remainingStudents = new ArrayList<>();

        while (!queue.isEmpty()) {
        	remainingStudents.add(queue.poll());
        }
        
        return remainingStudents;
    }

}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}