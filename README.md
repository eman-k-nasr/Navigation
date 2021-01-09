# Android Jetpack's Navigation component(using kotlin)
Android Jetpack's Navigation component helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer.
## Benefits:
- Handling fragment transactions.
- Handling Up and Back actions correctly by default.
- Providing standardized resources for animations and transitions.
- Implementing and handling deep linking.
- Complex Navigation UI patterns such as:
  navigation drawers, bottom navigation with minimal additional work.
- Safe Args : a Gradle plugin that provides type safety when navigating and passing data between destinations.
- ViewModel support : share UI-related data between the graph's destinations.
 
## The Navigation component consists of three key parts:
- #### Navigation graph:
  An XML resource that contains all navigation-related information in one centralized location
- #### NavHostFragment:
  An empty container that swaps in/out different destinations from your navigation graph. 
- #### NavController:
  An object that manages app navigation within a navigation host .
## Requirements:
If you want to use Navigation with Android Studio,you must use Android Studio 3.3 or higher.
## How to work with Navigation Component?!
- #### add dependecies:
  ###### at project level build.gradle add inside ext block
  ```
  navigationVersion = "2.3.0"
  ```
  ###### at module level build.gradle add inside dependencies block
  ```
  implementation "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
  implementation "androidx.navigation:navigation-ui-ktx:$navigationVersion"
  ```
- #### create nav graph:
  ###### create a navigation resource type from this path:
  ```
  res->new->android resource file->navigation(res type)->navigation(file name)
  ```
  ###### start adding all destinations you have :
  <img src=https://user-images.githubusercontent.com/59161258/104088921-01368900-5273-11eb-94e3-8fc464f5cd1b.png width="600" height="400">
  
- #### Add a NavHost to an activity:
  ###### open res->layout->activity_main->code view[add fragment widget inside parent layout]
  ```
      <fragment
        android:id="@+id/nav_host"
        android:name="androidx.navigation.fragment.NavHostFragment"
        app:navGraph="@navigation/navigation"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
        
```        
        
