# Sample-Quotes

This project make use of API to fetch Quotes from  [Mindful Quotes API.](https://servicegateway.7mind.de/v2/mindful?lang=en&uid=abc).

### Tech Stack
The following are used in the project:
- Kotlin
- MVVM Architecture
- Lifecycle Aware Components
- Android Navigation Component
- Jetpack Compose
- Coroutines
- ROOM
- Retrofit
- Glide

### Flavours
The project contain 3 flavors that can be used to configure different environments:
- Development
- Staging
- Production

The following things are configured in flavors:
- App Name
- Base Url
- Url Path
- Server Version

The above configurations are done in:
**_<project_path>/app/build.gradle_**


## Different components used in the project:

- [Clean Architecture][architecture] This app is structured using single module clean architecture

- [Jetpack Compose][compose] For creating beautiful screens

- [Compose navigation][navigation] For navigation in the app

- [ViewModel][viewmodel] The presentation layer uses the viewmodel pattern

- [Hilt][hilt] For dependency injection

- [Coroutines][coroutines] For handling async work

- [Retrofit][retrofit] For networking tasks



[architecture]: https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html
[compose]: https://developer.android.com/jetpack/compose?gclid=CjwKCAjwyIKJBhBPEiwAu7zll9bjLDRqSH7XtNL-G0txRAeT_QLCcws-_VYPI9Ea-cxFzEC69YbslxoC6BEQAvD_BwE&gclsrc=aw.ds
[navigation]: https://developer.android.com/jetpack/compose/navigation
[viewmodel]: https://developer.android.com/topic/libraries/architecture/viewmodel
[hilt]: https://developer.android.com/training/dependency-injection/hilt-android
[coroutines]: https://developer.android.com/kotlin/coroutines
[retrofit]: https://square.github.io/retrofit/