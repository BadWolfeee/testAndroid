package pl.badwolfeee.mediaplayer;

        import android.media.MediaPlayer;
        import android.os.Bundle;
        import android.app.Activity;
        import android.view.View;
public class MainActivity extends Activity {
    MediaPlayer mp;
    double startTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void start(View view) {
        mp = MediaPlayer.create(this, R.raw.promise_me);
        mp.seekTo((int) startTime);
        mp.start();
    }
    public void pause(View view) {
        if (mp != null && mp.isPlaying()) {
            startTime = mp.getCurrentPosition();
            mp.pause();
        }
    }
    public void stop(View view) {
        if (mp != null && mp.isPlaying()) {
            startTime = 0;
            mp.stop();
        }
    }
}
