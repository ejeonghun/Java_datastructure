package s240416;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Song implements Comparable<Song> { // Song 클래스 정의
    private String title;
    private String author;
    private int rank;
    public Song(String title, String author, int rank) { // 생성자
        super();
        this.title = title;
        this.author = author;
        this.rank = rank;
    }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public int getRank() { return rank; }
    public void setRank(int rank) { this.rank = rank; }
    public int compareTo(Song o) { // 정렬 기준 설정 : 랭킹
        return this.rank - o.rank;
    }
}
public class SongSortTest {
    public static void main(String[] args) {
        List<Song> songList = new ArrayList<>(); // 리스트 객체 생성
        songList.add(new Song("끝", "권진아", 4));
        songList.add(new Song("구르미 그린 달빛", "거미", 2));
        songList.add(new Song("이소설의 끝을 다시 써보려해 ", "한동근", 3));
        songList.add(new Song("다정하게,안녕히", "성시경", 5));
        songList.add(new Song("내가 저지른 사랑", "임창정", 1));
        System.out.println("정렬 전 ---------------------");
        for (Song song : songList)
            System.out.println(song.getTitle() + ", " + song.getAuthor() + ", "
                    + song.getRank() + "위");
        System.out.println("정렬 후 ---------------------");
        Collections.sort(songList); // 리스트 객체 정렬
        for (Song song : songList)
            System.out.println(song.getTitle() + ", " + song.getAuthor() + ", "
                    + song.getRank() + "위");
        System.out.println("역순출력 -------------------");
        Collections.reverse(songList); // 리스트 객체 역순 만들기
        for (Song song : songList)
            System.out.println(song.getTitle() + ", " + song.getAuthor() + ", "
                    + song.getRank() + "위");
    }
}