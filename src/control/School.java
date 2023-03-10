package control;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;

import model.Student;

public class School {
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Student> list = new ArrayList<Student>();
	
	public School() {
		super();
		String path = Paths.get("").toAbsolutePath().toString();
		loadData(path+"/src/sch.txt");
	}
	
	public void loadData(String fName) {
		File f = new File(fName);
		if(!f.exists()) throw new RuntimeException("File is not exit!");
		String data = "";
		try {
			FileReader fr = new FileReader(fName);
			Scanner br = new Scanner(fr);
			while(br.hasNextLine()) {
				data = br.nextLine();
				String[] d = data.split(";");
				list.add(new Student(d[0], d[1], Double.parseDouble(d[2])));
			}
			br.close();
			fr.close();
		} catch (Exception ex){
			System.out.println("Unknow error!");
		}
	}
	
	public void listAllStudent(ArrayList<Student> list) {
		for (Student ls : list) {
			System.out.println(ls.toString());
		}
	}
	
	public void listAllStudent() {
		for (Student ls : list) {
			System.out.println(ls.toString());
		}
	}
	
	public ArrayList<Student> search (Predicate<Student> st) {
		ArrayList<Student> tempList = new ArrayList<Student>();
		for (Student ls : list) {
			if(st.test(ls)) tempList.add(ls);
		}
		return tempList;
	}
	
	public void addStudent() {
		list.add(this.info());
		System.out.println("Add successfully!");
		writeData();
	}
	
	private Student info() {
		System.out.println("ID: ");
		String id = sc.nextLine();
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Average score: ");
		double average = Double.parseDouble(sc.nextLine());
		
		return new Student(id, name, average);
	}
	

	
	public void writeData() {
		try {
		      FileWriter wf = new FileWriter("StoreData.txt");
		      for(Student std: list) {
		    	  wf.write(std + System.lineSeparator());
		    	}
		      wf.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
//    public void findByName(String name) {
//        ArrayList<Student> studentList = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            if (name.equals(list.get(i).getName())) {
//                studentList.add(list.get(i));
//            }
//        }
//        System.out.println(studentList);
//    }
//    
//    public void findById(String id) {
//        boolean flag = false;
//        int index = 0;
//        for (int i = 0; i < list.size(); i++) {
//            if (id.equals(list.get(i).getId())) {
//                flag = true;
//                index = i;
//                break;
//            }
//        }
//        if (flag) {
//            System.out.println(list.get(index));
//        } else {
//            System.out.println("no student");
//        }
//    }
	
    public void sortByID() {
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        this.listAllStudent();
    }
    
    public void sortByName() {
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        this.listAllStudent();
    }

    public void sortByAverage() {
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getAverage(), o2.getAverage());
            }
        });
        this.listAllStudent();
    }
}
