# GeneralWindow
通用弹框

## gradle使用：

一、Project下的build.gradle文件下添加

allprojects {
    repositories {
      ...
      maven { url 'https://jitpack.io' }
    }
}

二、Module下的build.gradle文件下添加

1.1.0以前

dependencies {
          
    implementation 'com.github.Lvluffy:GeneralDialog:1.1.0'
          
}

1.1.1以后

dependencies {
          
    implementation 'com.github.Lvluffy.GeneralDialog:toastlib:1.1.1'
    
    implementation 'com.github.Lvluffy.GeneralDialog:dialoglib:1.1.1'
    
    implementation 'com.github.Lvluffy.GeneralDialog:popupwindowlib:1.1.1'
          
}

## 录屏
![oy9um-9lsri](https://user-images.githubusercontent.com/34730376/56352315-8c4f3000-6201-11e9-9a80-3c119245a0cc.gif)
