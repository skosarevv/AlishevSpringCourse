package dev.skosarev.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(player.getName());
        System.out.println(player.getVolume());

        Music music1 = context.getBean("classicalMusic", ClassicalMusic.class);
        Music music2 = context.getBean("classicalMusic", ClassicalMusic.class);

        System.out.println(music1 == music2);

        context.close();
    }
}
