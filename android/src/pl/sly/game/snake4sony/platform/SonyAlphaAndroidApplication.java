package pl.sly.game.snake4sony.platform;

import android.content.Intent;
import android.view.KeyEvent;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.github.ma1co.openmemories.framework.DisplayManager;
import com.sony.scalar.sysutil.ScalarInput;

/**
 * A customized {@link AndroidApplication} class that prevents close app after click on
 * buttons like Playback / Take photo etc.
 */
public class SonyAlphaAndroidApplication extends AndroidApplication implements DisplayManager.Listener {

    private DisplayManager displayManager;

    @Override
    protected void onResume() {
        super.onResume();
        displayManager = DisplayManager.create(this);
        displayManager.addListener(this);
        setColorDepth(true);
        notifyAppInfo();    // required
    }

    @Override
    protected void onPause() {
        super.onPause();
        setColorDepth(false);
        displayManager.release();
        displayManager = null;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (event.getScanCode()) {
            case ScalarInput.ISV_KEY_UP:
                return onUpKeyDown();
            case ScalarInput.ISV_KEY_DOWN:
                return onDownKeyDown();
            case ScalarInput.ISV_KEY_LEFT:
                return onLeftKeyDown();
            case ScalarInput.ISV_KEY_RIGHT:
                return onRightKeyDown();
            case ScalarInput.ISV_KEY_ENTER:
                return onEnterKeyDown();
            case ScalarInput.ISV_KEY_FN:
                return onFnKeyDown();
            case ScalarInput.ISV_KEY_AEL:
                return onAelKeyDown();
            case ScalarInput.ISV_KEY_MENU:
            case ScalarInput.ISV_KEY_SK1:
                return onMenuKeyDown();
            case ScalarInput.ISV_KEY_S1_1:
                return onFocusKeyDown();
            case ScalarInput.ISV_KEY_S1_2:
                return true;
            case ScalarInput.ISV_KEY_S2:
                return onShutterKeyDown();
            case ScalarInput.ISV_KEY_PLAY:
                return onPlayKeyDown();
            case ScalarInput.ISV_KEY_STASTOP:
                return onMovieKeyDown();
            case ScalarInput.ISV_KEY_CUSTOM1:
                return onC1KeyDown();
            case ScalarInput.ISV_KEY_DELETE:
            case ScalarInput.ISV_KEY_SK2:
                return onDeleteKeyDown();
            case ScalarInput.ISV_KEY_LENS_ATTACH:
                return onLensAttached();
            case ScalarInput.ISV_DIAL_1_CLOCKWISE:
            case ScalarInput.ISV_DIAL_1_COUNTERCW:
                return onUpperDialChanged(getDialStatus(ScalarInput.ISV_DIAL_1_STATUS) / 22);
            case ScalarInput.ISV_DIAL_2_CLOCKWISE:
            case ScalarInput.ISV_DIAL_2_COUNTERCW:
                return onLowerDialChanged(getDialStatus(ScalarInput.ISV_DIAL_2_STATUS) / 22);
            case ScalarInput.ISV_KEY_MODE_DIAL:
                return onModeDialChanged(getDialStatus(ScalarInput.ISV_KEY_MODE_DIAL));
            default:
                return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (event.getScanCode()) {
            case ScalarInput.ISV_KEY_UP:
                return onUpKeyUp();
            case ScalarInput.ISV_KEY_DOWN:
                return onDownKeyUp();
            case ScalarInput.ISV_KEY_LEFT:
                return onLeftKeyUp();
            case ScalarInput.ISV_KEY_RIGHT:
                return onRightKeyUp();
            case ScalarInput.ISV_KEY_ENTER:
                return onEnterKeyUp();
            case ScalarInput.ISV_KEY_FN:
                return onFnKeyUp();
            case ScalarInput.ISV_KEY_AEL:
                return onAelKeyUp();
            case ScalarInput.ISV_KEY_MENU:
            case ScalarInput.ISV_KEY_SK1:
                return onMenuKeyUp();
            case ScalarInput.ISV_KEY_S1_1:
                return onFocusKeyUp();
            case ScalarInput.ISV_KEY_S1_2:
                return true;
            case ScalarInput.ISV_KEY_S2:
                return onShutterKeyUp();
            case ScalarInput.ISV_KEY_PLAY:
                return onPlayKeyUp();
            case ScalarInput.ISV_KEY_STASTOP:
                return onMovieKeyUp();
            case ScalarInput.ISV_KEY_CUSTOM1:
                return onC1KeyUp();
            case ScalarInput.ISV_KEY_DELETE:
            case ScalarInput.ISV_KEY_SK2:
                return onDeleteKeyUp();
            case ScalarInput.ISV_KEY_LENS_ATTACH:
                return onLensDetached();
            case ScalarInput.ISV_DIAL_1_CLOCKWISE:
            case ScalarInput.ISV_DIAL_1_COUNTERCW:
                return true;
            case ScalarInput.ISV_DIAL_2_CLOCKWISE:
            case ScalarInput.ISV_DIAL_2_COUNTERCW:
                return true;
            case ScalarInput.ISV_KEY_MODE_DIAL:
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }

    protected int getDialStatus(int key) {
        return ScalarInput.getKeyStatus(key).status;
    }
    protected boolean onUpKeyDown() { return false; }
    protected boolean onUpKeyUp() { return false; }
    protected boolean onDownKeyDown() { return false; }
    protected boolean onDownKeyUp() { return false; }
    protected boolean onLeftKeyDown() { return false; }
    protected boolean onLeftKeyUp() { return false; }
    protected boolean onRightKeyDown() { return false; }
    protected boolean onRightKeyUp() { return false; }
    protected boolean onEnterKeyDown() { return false; }
    protected boolean onEnterKeyUp() { return false; }
    protected boolean onFnKeyDown() { return false; }
    protected boolean onFnKeyUp() { return false; }
    protected boolean onAelKeyDown() { return false; }
    protected boolean onAelKeyUp() { return false; }
    protected boolean onMenuKeyDown() { return false; }
    protected boolean onMenuKeyUp() {
        onBackPressed();
        return false;
    }
    protected boolean onFocusKeyDown() { return false; }
    protected boolean onFocusKeyUp() { return false; }
    protected boolean onShutterKeyDown() { return false; }
    protected boolean onShutterKeyUp() { return false; }
    protected boolean onPlayKeyDown() { return false; }
    protected boolean onPlayKeyUp() { return false; }
    protected boolean onMovieKeyDown() { return false; }
    protected boolean onMovieKeyUp() { return false; }
    protected boolean onC1KeyDown() { return false; }
    protected boolean onC1KeyUp() { return false; }
    protected boolean onLensAttached() { return false; }
    protected boolean onLensDetached() { return false; }
    protected boolean onUpperDialChanged(int value) { return false; }
    protected boolean onLowerDialChanged(int value) { return false; }
    protected boolean onModeDialChanged(int value) { return false; }
    protected boolean onDeleteKeyDown() {
        return true;
    }
    protected boolean onDeleteKeyUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void displayChanged(DisplayManager.Display display) {

    }

    protected void setColorDepth(boolean highQuality) {
        displayManager.setColorDepth(highQuality ? DisplayManager.ColorDepth.HIGH : DisplayManager.ColorDepth.LOW);
    }

    protected void notifyAppInfo() {
        Intent intent = new Intent("com.android.server.DAConnectionManagerService.AppInfoReceive");
        intent.putExtra("package_name", getComponentName().getPackageName());
        intent.putExtra("class_name", getComponentName().getClassName());
        sendBroadcast(intent);
    }
}
