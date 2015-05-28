package xyz.praveen.lyricx.model;

/**
 * Created by praveen on 28/5/15.
 * Fields documentation at http://www.chartlyrics.com/api.aspx
 */
public class GetLyricResult {
    String TrackChecksum;
    int TrackId;
    String LyricChecksum;
    int LyricId;
    String LyricSong;
    String LyricArtist;
    String LyricUrl;
    String LyricCovertArtUrl;
    int LyricRank;
    String LyricCorrectUrl;
    String Lyric;

    public String getTrackChecksum() {
        return TrackChecksum;
    }

    public void setTrackChecksum(String trackChecksum) {
        TrackChecksum = trackChecksum;
    }

    public int getTrackId() {
        return TrackId;
    }

    public void setTrackId(int trackId) {
        TrackId = trackId;
    }

    public String getLyricChecksum() {
        return LyricChecksum;
    }

    public void setLyricChecksum(String lyricChecksum) {
        LyricChecksum = lyricChecksum;
    }

    public int getLyricId() {
        return LyricId;
    }

    public void setLyricId(int lyricId) {
        LyricId = lyricId;
    }

    public String getLyricSong() {
        return LyricSong;
    }

    public void setLyricSong(String lyricSong) {
        LyricSong = lyricSong;
    }

    public String getLyricArtist() {
        return LyricArtist;
    }

    public void setLyricArtist(String lyricArtist) {
        LyricArtist = lyricArtist;
    }

    public String getLyricUrl() {
        return LyricUrl;
    }

    public void setLyricUrl(String lyricUrl) {
        LyricUrl = lyricUrl;
    }

    public String getLyricCovertArtUrl() {
        return LyricCovertArtUrl;
    }

    public void setLyricCovertArtUrl(String lyricCovertArtUrl) {
        LyricCovertArtUrl = lyricCovertArtUrl;
    }

    public int getLyricRank() {
        return LyricRank;
    }

    public void setLyricRank(int lyricRank) {
        LyricRank = lyricRank;
    }

    public String getLyricCorrectUrl() {
        return LyricCorrectUrl;
    }

    public void setLyricCorrectUrl(String lyricCorrectUrl) {
        LyricCorrectUrl = lyricCorrectUrl;
    }

    public String getLyric() {
        return Lyric;
    }

    public void setLyric(String lyric) {
        Lyric = lyric;
    }
}
