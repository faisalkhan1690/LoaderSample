# Loaders Example 
===================================
> An Example how to use loaders in android 
This sample cover two things 

1. AsyncTask Loader
2. Cursor Loader 

Loaders are introduced in Android 3.0. The main reason because of that loader comes in picture that Loader always loader data in background. So this will never cause the app to feel unresponsive or to not even display an ANR error message. We can accomplish this thing using AsyncTask and thread but the problem with these two on orientation change or any unexpected behaviour of app you need to do extra code for handling AsyncTask and thread. But if you are using Loader then it works on unique id so one loader will not execute again until you want. And must batter with AsyncTask and thread in case of unexpected behaviour of app.

AsyncTaskLoader
-------
android.content.AsyncTaskLoader<D> is a loader that uses AsyncTask to perform the task. It is an abstract class and to use it we need to extend and override its methods. In our example we will iterate a list using ListView.
 Find some methods that need to be overridden.

```Java
   loadInBackground() :
           Performs actual task in background and returns the result.
   onCanceled(D data) :
           This method is called if task is cancelled before completion. It is used to clean up data post cancellation.
   cancelLoadInBackground() :
           We override this method to cancel the background process. If there is no process in background, it is not going to be called.
```

CursorLoader
-------
 The concept of Loaders was introduced in Android 3.0 (API Level 11).
 There are three key benefits of using a CursorLoader:
 The query is handled on a background thread for you (courtesy of being built on AsyncTaskLoader)
 so that large data queries do not block the UI.
 This is something the docs recommended for you to do when you’re using a plain Cursor, but now it's done under the hood.
 CursorLoader is auto-updating. In addition to performing the initial query, CursorLoader also registers a ContentObserver
 with the data set you requested and calls forceLoad() on itself when the data set changes.
 This results in getting async callbacks anytime the data changes in order to update the view.
 Now follow these simple steps: Here we will create a list of all the contacts stored in an android device.

Pre-requisites
--------------

- Android SDK v23
- Android Build Tools v23.0.2

  

References
--------------
https://developer.android.com/guide/components/loaders.html
https://developer.android.com/reference/android/app/LoaderManager.html
https://developer.android.com/reference/android/app/LoaderManager.LoaderCallbacks.html
https://developer.android.com/reference/android/content/AsyncTaskLoader.html
https://developer.android.com/reference/android/content/CursorLoader.html


Screenshots
--------------
![device-2017-02-25-194253](https://cloud.githubusercontent.com/assets/7554816/23331828/dd301f56-fb93-11e6-919b-224df7e9529c.png)
![device-2017-02-25-194720](https://cloud.githubusercontent.com/assets/7554816/23331829/dd31480e-fb93-11e6-8ee6-8caf0d2126f5.png)
![device-2017-02-25-194750](https://cloud.githubusercontent.com/assets/7554816/23331830/dd36b5f0-fb93-11e6-9756-cd6d28110569.png)
