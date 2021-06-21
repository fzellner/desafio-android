object Versions {

    const val kotlin_version = "1.4.32"
    const val appcompat_version = "1.1.0"
    const val core_ktx_version = "1.2.0"
    const val core_testing_version = "2.1.0"
    const val constraintlayout_version = "1.1.3"
    const val material_version = "1.1.0"
    const val retrofit_version = "2.7.1"
    const val retrofitCoroutines = "0.9.2"
    const val okhttp_version = "4.3.1"
    const val picasso_version = "2.71828"
    const val circleimageview_version = "3.0.0"
    const val junit_version = "4.12"
    const val mockito_version = "3.11.1"
    const val mockito_kotlin_version = "2.1.0"
    const val test_runner_version = "1.1.1"
    const val espresso_version = "3.1.1"
    const val koin_version = "2.0.1"
    const val lifecycle_version = "2.2.0"
    const val coroutines_version = "1.3.3"
    const val core_ktx_test_version = "1.2.0"
    const val navigation_version = "2.3.0"
    const val room_version = "2.3.0"
    const val mockk = "1.9.3"


}

object Libraries {

    //region Main core implementations
    //core
    private const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
    private const val coreKtx = "androidx.core:core-ktx:${Versions.core_ktx_version}"

    //lifecycle
    private const val lifeCycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    private const val lifeCycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
    private const val lifeCycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_version}"

    //coroutines
    private const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines_version}"
    private const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_version}"

    //room
    private const val room = "androidx.room:room-runtime:${Versions.room_version}"
    private const val roomKTX = "androidx.room:room-ktx:${Versions.room_version}"
    private const val roomAnnotation = "androidx.room:room-compiler:${Versions.room_version}"

    //endregion
    val core = listOf(
        kotlin,
        coreKtx,
        lifeCycleLiveData,
        lifeCycleRuntime,
        lifeCycleViewModel,
        coroutinesCore,
        coroutinesAndroid
    )

    //http
    private const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    private const val retrofitCoroutines =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
    private const val gsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}"
    private const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp_version}"
    private const val okhttp3Interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_version}"
    private const val mockWebServer =
        "com.squareup.okhttp3:mockwebserver:${Versions.okhttp_version}"
    val http = listOf(retrofit2,
        retrofitCoroutines,
        gsonConverter,
        okhttp3,
        mockWebServer,
        gsonConverter,
        okhttp3Interceptor)

    //dependency injection
    private const val koinCore = "org.koin:koin-core:${Versions.koin_version}"
    private const val koinAndroid = "org.koin:koin-android:${Versions.koin_version}"
    private const val koinViewModelScope =
        "org.koin:koin-androidx-viewmodel:${Versions.koin_version}"
    private const val koinTest = "org.koin:koin-test:${Versions.koin_version}"
    val koin = listOf(koinCore, koinAndroid, koinViewModelScope, koinTest)

    //ui
    private const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat_version}"
    private const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout_version}"
    private const val material = "com.google.android.material:material:${Versions.material_version}"
    private const val picasso = "com.squareup.picasso:picasso:${Versions.picasso_version}"
    private const val circleImageView =
        "de.hdodenhof:circleimageview:${Versions.circleimageview_version}"
    val ui = listOf(material, constraintLayout, appcompat, picasso, circleImageView)

    //navigation
    private const val navigationKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation_version}"
    private const val navigationUi =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigation_version}"
    val navigation = listOf(navigationKtx, navigationUi)

    //instrumented tests
    private const val junit = "junit:junit:${Versions.junit_version}"
    private const val mockk = "io.mockk:mockk:${Versions.mockk}"
    private const val archCoreTesting =
        "androidx.arch.core:core-testing:${Versions.core_testing_version}"
    private const val coroutineTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines_version}"
    private const val testRunner = "androidx.test:runner:${Versions.test_runner_version}"

    private const val mockitokotlin =  "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito_kotlin_version}"
    private const val mockito =  "org.mockito:mockito-core:${Versions.mockito_version}"
    private const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso_version}"
    private const val coreKtxTest = "androidx.test:core-ktx:${Versions.core_ktx_test_version}"
    val testing = listOf(junit, testRunner, espresso, coreKtxTest, mockk, mockito, mockitokotlin, archCoreTesting, coroutineTest)
}

object GradleTemplates {
    const val feature = "template-feature.gradle"
}

