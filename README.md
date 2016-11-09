В этом репозитории находится тестовое приложение, демонстрирующее возможности Yandex Map Kit.

ChangeLog
----------

version 2.5.2

1. Исправлены ошибки при отображении карты
2. Добавлен arm64-v8a и x86_64 архитектуры

version 2.5.1
 
 1. Исправлены ошибки отображения кнопок на карте
 2. Добавлен пример работы с запросом разрешений на получения геопозиции

version 2.5.0
 
 1. Исправлены ошибки, приводившие к падениям
 2. Удалены все запросы разрешений, кроме получения геопозиции
 

Как начать
------------

1.  Клонируйте репозиторий примера
    git clone https://github.com/yandexmobile/yandexmapkit-android.git
2.  В папке yandexmapkit-sample находится пример приложения который через gradle зависимость подключает мапкит
3.  Данные проекты уже настроены для работы в среде Eclipse
 1.	Импортируйте данные проекты в среду Eclipse или Android Studio
 2. Выполняете Gradle Sync для  проекта. 
4.  Подставьте свой API ключ во все layout где используется объект MapView
5.  Всё готово к запуску тестового проекта

Запуск из командной строки.

    gradlew assembleDebug

Gradle:
```groovy

allprojects {
    repositories {
        jcenter()
        maven { url 'https://github.com/yandexmobile/yandexmapkit-android/raw/maven/' }
    }
}

dependencies {
    compile 'ru.yandex:yandexmapkit:2.5.1@aar'
}

```

Миграция с первой версии
-------------------------

1. При создании OverlayItem необходимо в конструкторе вместо объекта  Bitmap  передавать Drawable, можно воспользоваться new BitmapDrawable(you_bitmap)
2. При создании объекта BalloonItem необходимо в конструкторе передавать Context (необходимый для загрузки ресурсов)
3. Исправить использования интерфейса с OnBallonListener на OnBalloonListener и добавить новые методы из данного интерфейса
4. Исправить имя метода у BalloonItem с setOnBallonListener на setOnBalloonViewClickListener
5. Необходимо изменить логику работы интерфейса  OnBalloonListener  метода  onBallonClick  на  onBalloonViewClick


Интеграция с Яндекс.Картами
---------------------------
Документация по интеграции с мобильными Яндекс.Картами выложена на [tech.yandex.ru](https://tech.yandex.ru/yandex-apps-launch/maps/)

Дополнительная информация
---------------------------

Также у этого проекта есть:
* [Wiki](https://github.com/yandexmobile/yandexmapkit-android/wiki), в которой содержится полезная информация о Yandex Map Kit.
* JavaDoc, который находится в yandexmapkit-library/doc. В нем содержится описание классов и методов Yandex Map Kit.

Если вы хотите сообщить об ошибке или предложить идею в развитии, то напишите об этом, пожалуйста, в [Issues](https://github.com/yandexmobile/yandexmapkit-android/issues).
