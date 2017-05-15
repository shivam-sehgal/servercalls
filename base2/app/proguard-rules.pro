# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\Android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
# Retrofit 2.X
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }

# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions

-dontwarn okio.**

#paper Db
#-keep class com.skeleton.model.** { *; }

-keep class org.objenesis.** { *; }
-keep interface org.objenesis.** { *; }
-dontwarn org.objenesis.**

-keep class com.skeleton.retrofit.APIError { *; }

# Preserve opentok streaming dependencies
#-keep class com.opentok.** { *; }
#-keep class org.webrtc.** { *; }

# For improved crash reporting with Crashlytics
-keepattributes SourceFile,LineNumberTable
