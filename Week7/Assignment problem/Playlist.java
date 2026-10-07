import java.util.Arrays;

public class Playlist {
    private final String[] songs; // Private fixed-size array[cite: 4]
    private int songCount;         // Tracks number of songs added[cite: 4]

    // Constructor setting fixed capacity[cite: 4]
    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.songCount = 0;
    }

    // Adds a song if there is room available[cite: 4]
    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    // Returns a safe copy of only the added songs so far[cite: 4]
    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount); // Creates a new array copy up to current songCount[cite: 4]
    }

    // Read-only count of added songs[cite: 4]
    public int getSongCount() {
        return songCount; //[cite: 4]
    }
}
