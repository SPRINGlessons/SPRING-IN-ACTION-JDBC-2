package com.tutorialspoint;

// This Project created by Anton Romanov (www.antonromanov.com) 06.02.2018 at 09:45
// Source book - Spring in Action
// Git Hub repo - ...

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("Beans.xml");



        MyDatabaseBean dataBean = (MyDatabaseBean) ctx.getBean("mydatabean");
        dataBean.add();
      //  dataBean.addwithParam(new User("Vasya"));
        System.out.println("Our user is = " + dataBean.findUsers(1).getName());

        //System.out.println(dataBean.allUsers().toArray().toString());
        dataBean.allUsers().forEach(System.out::println);



        for(User user: dataBean.allUsersAsObjects()) {
            System.out.println(user);
        }








    }



}
