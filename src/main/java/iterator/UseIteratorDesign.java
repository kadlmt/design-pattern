package iterator;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * 迭代器模式
 * @author liumt
 * @date 20:45 2020/10/27.
 */
public class UseIteratorDesign {
    public static void main(String[] args) {
        Student student1 = new Student("小明");
        Student student2 = new Student("小王");

        ClassRoom classroom = new ClassRoom(2);
        classroom.addStudent(student1);
        classroom.addStudent(student2);

        Iterator iterator = classroom.iterator();
        while(iterator.hasNext()) {
            Student student = (Student) iterator.next();
            System.out.println(student.getName());
        }
    }

    /**
     * 自定义迭代器接口
     */
    public interface Iterator {
        boolean hasNext();
        Object next();
    }

    /**
     * 自定义集合接口
     */
    public interface Aggregate {
        Iterator iterator();
    }

    /**
     * 学生类
     */
    public static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * 教室迭代器
     */
    public static class ClassRoomIterator implements Iterator {
        private int index;
        private ClassRoom classRoom;

        public ClassRoomIterator(ClassRoom classRoom) {
            this.classRoom = classRoom;
        }

        @Override
        public boolean hasNext() {
            if(index < classRoom.getLength()){
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Object next() {
            Student student = classRoom.getIndex(index);
            index++;
            return student;
        }
    }

    /**
     * 教室类
     */
    public static class ClassRoom implements Aggregate {
        private Student[] students;
        private int last;

        public ClassRoom(int size) {
            this.students = new Student[size];
        }

        public Student getIndex(int index) {
            return students[index];
        }

        public void addStudent(Student student) {
            students[last] = student;
            last++;
        }

        public int getLength() {
            return students.length;
        }

        /**
         * 返回教室迭代器
         * @return
         */
        @Override
        public Iterator iterator() {
            return new ClassRoomIterator(this);
        }
    }
}
