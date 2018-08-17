package wellijohn.org.multilevelrecyclerview;

import java.util.ArrayList;
import java.util.List;

import wellijohn.org.treerecyclerview.vo.Tree;
import wellijohn.org.treerecyclerview.vo.TreeItem;

/**
 * @author: WelliJohn
 * @time: 2018/8/17-16:37
 * @email: wellijohn1991@gmail.com
 * @desc:
 */
public class TestData {
    public static List<Person> getTestData() {
        List<Person> list = new ArrayList<Person>();
        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            list.add(person);
        }
        return list;
    }

    static class Person extends TreeItem {
        private boolean isOpean = true;
        List<Person1> list = new ArrayList<Person1>();

        public Person() {
            Person1 person1 = new Person1();
            list.add(person1);
            person1.setOpen(false);
            Person1 person2 = new Person1();
            person2.setOpen(false);
            list.add(person2);
        }

        public int getLevel() {
            return 0;
        }

        public List getChilds() {

            return list;
        }

    }

    static class Person1 extends TreeItem {
        List<Person2> list = new ArrayList<Person2>();


        public Person1() {
            Person2 person1 = new Person2();
            list.add(person1);
            Person2 person2 = new Person2();
            list.add(person2);
        }

        public int getLevel() {
            return 1;
        }


        public List getChilds() {

            return list;
        }

    }

    static class Person2 extends TreeItem {

        public int getLevel() {
            return 2;
        }


        public List<Tree> getChilds() {
            return null;
        }

    }
}

