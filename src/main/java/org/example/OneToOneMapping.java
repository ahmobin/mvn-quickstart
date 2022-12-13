package org.example;

import org.example.entities.Answer;
import org.example.entities.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMapping {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Answer answer1 = new Answer();
        answer1.setAnswer("Java is a programming Language.");

        Question question1 = new Question();
        question1.setQuestion("What is Java");
        question1.setAnswer(answer1);
        answer1.setQuestion(question1);

        Answer answer2 = new Answer();
        answer2.setAnswer("API stands for Application Programing Interface.");

        Question question2 = new Question();
        question2.setQuestion("What is the full abbreviation of API");
        question2.setAnswer(answer2);


        Session session = factory.openSession();
        Transaction trx = session.beginTransaction();

        session.save(answer1);
        session.save(answer2);
        session.save(question1);
        session.save(question2);

        trx.commit();

        Question getQues1 = session.load(Question.class,1);
//        System.out.println(getQues1);
//        System.out.println(getQues1.getAnswer());

        Answer getAns1 = session.load(Answer.class,1);
        System.out.println(getAns1);

        session.close();
        factory.close();


    }

}
