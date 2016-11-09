Gradle:
```groovy

allprojects {
    repositories {
        jcenter()
        maven { url 'https://github.com/yandexmobile/yandexmapkit-android/raw/maven/' }
    }
}

dependencies {
    compile 'ru.yandex:yandexmapkit:2.5.2@aar'
}

```