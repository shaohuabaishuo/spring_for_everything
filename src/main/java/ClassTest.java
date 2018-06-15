import com.example.demo.User;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassTest {

    public static void main(String[] args) {

        String str = "abc";
        Class c=str.getClass();
        Method[] m= c.getMethods();
        for (int i=0;i<m.length;i++){
            System.out.println(m[i].getName());
        }

//        try {
//            Class x = Class.forName("java.lang.String");
//             System.out.println(x.getTypeParameters().length);
//            Method method = x.getMethod("equals", Object.class);
//
//            Object obj = method.invoke("1", "2");
//            System.out.println(obj);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        User user1 = new User("1", "123");
        User user2 = new User("2", "1234");
        User user3 = new User("3", "12");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        StringBuffer str1 = new StringBuffer();
        list.stream().filter(t -> t.getName().equals("1") || t.getName().equals("2")).forEach(x -> {
            if (x.getSex().equals("1234")) {
                str1.append("111111");
            }
        });
        list.forEach(System.out::print);
        System.out.println("xxxxxxxxxxxxxxxxxxxx" + str1);




    }

}
