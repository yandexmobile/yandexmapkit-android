Gradle:
```groovy

allprojects {
    repositories {
        jcenter()
        maven { url 'https://github.com/yandexmobile/yandexmapkit-android/raw/maven/' }
    }
}

dependencies {
    compile 'ru.yandex:yandexmapkit:2.4.1@aar'
}

```