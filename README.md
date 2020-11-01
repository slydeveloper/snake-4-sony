Snake-4-Sony
===============================================================
Long story short. After bought my camera `Sony Alpha A6300 (ILCE6300B)`, I realized that it contains the Android subsystem used to run apps from the `Sony PlayMemories Camera App Store`.
So I had idea to create some fancy software for it.

Project
-------
Main goal of this project was to create simple snake-like game and deploy on the Sony Alpha camera. Based on:
* libGDX framework - https://github.com/libgdx/libgdx
* Reverse engineering Sony PlayMemories Camera Apps https://github.com/ma1co/Sony-PMCA-RE

Sony Android cameras
--------------------
[link](https://github.com/ma1co/OpenMemories-Framework/blob/master/docs/Cameras.md)

Camera details:
---------------
* LCD: `2.95` inch
* API version: `15`
* Android version: `4.1.2`
* Android SDK version: `16`
* Android incremental version: `70`
* OpenGL version: `2`
* Screen: `854x480`
* Frame buffer: `640x480`

Tested on:
----------
* macOS Catalina `10.15.7`
* Camera: `Sony Alpha A6300` | `Android 4.1.2`
* Android TV: `Sony KDL-55W755C` | `Android 9.0`
* Smartphone: `Samsung SM-A310F` | `Android 7.0`

Screens
--------------------------
![Screen](screen_desktop.png)
![Screen](screen_sony.jpeg)

Run
--------------------------
* On Sony Alpha Android:
  * configure WiFi connection on your camera
  * install https://github.com/ma1co/OpenMemories-Tweak on your camera to activate ADB
  * in camera menu, go to `Application list` and run `OpenMemories Tweak`
  * go to the tab: `Developer`
  * check `Enable Wifi` and `Enable ADB`
    * here receive IP address of your camera
  * on your OS go to the terminal and type: `adb connect YOUR_CAMERA_IP` 
  * deploy app via Android Studio
* On Desktop:
  * Run application from `desktop->DesktopLauncher.java` by click on `Run`
  * in case of issues configure asset folder:
  ![Screen](screen_desktop_run.png)

* On Android TV
  * check IP of your Android TV
    * `IP Scanner` tool on macOS
   * enable ADB [link](https://stackoverflow.com/questions/31421872/adb-connection-to-an-androidtv)
   * on your OS go to the terminal and type: `adb connect YOUR_TV_IP`
   * deploy app via Android Studio
* On Android Device
  * deploy as regular Android application