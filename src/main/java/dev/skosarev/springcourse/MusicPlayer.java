package dev.skosarev.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;
    private Music music;

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music music) {
        this.music = music;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public String playMusic() {
        return "Playing: " + music.getSong();
    }
}
