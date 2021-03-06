package cat.santi.android.tttf.commons;

import android.content.Context;
import android.media.MediaPlayer;
import cat.santi.android.tttf.R;

public class TTTFSoundManager {

//	MediaPlayer mMediaPlayer = null;
	
	private MediaPlayer mMediaPlayer = null;
	
	private static TTTFSoundManager mInstance = null;
	
	private TTTFSoundManager(Context context) {
		
		if(mMediaPlayer == null)
			mMediaPlayer = MediaPlayer.create(context, R.raw.slide);
	}
	
	public static TTTFSoundManager getInstance(Context context) {
		
		if(mInstance == null)
			mInstance = new TTTFSoundManager(context);
		return mInstance;
	}
	
	public void playSlide(Context context) {
		
		if(mMediaPlayer != null && mMediaPlayer.isPlaying()) {
			
			mMediaPlayer.pause();
			mMediaPlayer.stop();
		}
		
		mMediaPlayer = MediaPlayer.create(context, R.raw.slide);
		mMediaPlayer.start();
	}
	
	public void onPause() {
		
		if(mMediaPlayer != null) {
			
			mMediaPlayer.release();
			mMediaPlayer = null;
		}
	}
}
