package dev.skosarev.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Music music = context.getBean("rockMusic", RockMusic.class);

        MusicPlayer player = new MusicPlayer(music);

        player.playMusic();

        Music music2 = context.getBean("classicalMusic", ClassicalMusic.class);

        MusicPlayer classicalMusicPlayer = new MusicPlayer(music2);

        classicalMusicPlayer.playMusic();

        context.close();
    }
}
