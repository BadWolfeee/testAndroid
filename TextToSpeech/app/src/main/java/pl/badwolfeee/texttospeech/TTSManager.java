package pl.badwolfeee.texttospeech;

        import android.content.Context;
        import android.speech.tts.TextToSpeech;
        import java.util.Locale;
public class TTSManager {
    private TextToSpeech mTts = null;
    private boolean isLoaded = false;
    public void init(Context context) {
        try {
            mTts = new TextToSpeech(context, onInitListener);
        } catch (Exception e) {
            e.printStackTrace();
        }     }
    private TextToSpeech.OnInitListener onInitListener =
            new TextToSpeech.OnInitListener() {
                public void onInit(int status) {
                    if (status == TextToSpeech.SUCCESS) {
                        Locale loc = new Locale("pl_PL");
                        int result = mTts.setLanguage(loc);
                        isLoaded = true;
                    }
                }
            };
    public void shutDown() {
        mTts.shutdown();
    }
    public void initQueue(String text) {
        if (isLoaded)
            mTts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}