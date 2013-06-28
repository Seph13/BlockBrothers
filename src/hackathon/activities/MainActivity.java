package hackathon.activities;

import java.util.Map;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.util.FPSLogger;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

public class MainActivity extends SimpleBaseGameActivity {

	private static final int CAMERA_WIDTH = 480;
	private static final int CAMERA_HEIGHT = 320;
	
	Map<String,BitmapTextureAtlas> textures;
	Map<String,ITextureRegion> textureRegions;
	Scene scene;
	ITextureRegion playerTextureRegion;
	Camera camera;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		this.camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		final EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.camera);
		engineOptions.getTouchOptions().setNeedsMultiTouch(false);
		return engineOptions;
	}

	@Override
	protected void onCreateResources() {

	}

	@Override
	protected Scene onCreateScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());

		final Scene scene = new Scene();
		scene.setBackground(new Background(0, 0, 1.0f));
		
		return scene;
	}

}
