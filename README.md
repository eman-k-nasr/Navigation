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
        app:layout_constraintTop_toTopOf="parent"/>
        
   ```  

## How to pass data between destinations through safeArgs?!
- #### in nav graph click on the destination that receives the argument.
- #### click on Arguments(+)
- #### add argument u want determine name , type 
  <img src=https://user-images.githubusercontent.com/59161258/104103484-08798900-52ab-11eb-82e8-0b16fb07778e.jpg width="600" height="400">    
  <img src=https://user-images.githubusercontent.com/59161258/104103563-69a15c80-52ab-11eb-85f1-04024cbb3b5a.jpg width="600" height="400">
#### for code:
 - #### add dependency
###### inside build.gradle(project) add this class path 
```
   dependencies {
     classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
    }
```
###### inside build.gradle(module) add safeArgs plugin inside plugins block 
```
plugins {
    id 'androidx.navigation.safeargs'
} 
```
 - #### It's time to build the project [to access generated classes by safeArgs plugin]
 - #### [Sender] Inside The Sending Fragment add the following code 
```
btn.setOnClickListener {
   val name = nameEt.text.toString()
   val action = Fragment_ADirections.actionFragmentAToFragmentB(name)
   it.findNavController().navigate(action)
}
```  
 - #### [Receiver] Inside The Receiving Fragment add the following code
```
val args: Fragment_BArgs by navArgs()
```
```
val name = args.name
nameTv.text = name
```
## How to pass data between destinations through safeArgs(Custom Object)?!
- #### first create your custom object 
```
data class User(val name:String,val job:String)
```
- #### add this plugin inside build.gradle(module) add safeArgs plugin inside plugins block
```
id 'kotlin-android-extensions'
```
- #### make the class extends from Parcelable class and add Parcelize annotation 
```
@Parcelize
data class User(val name:String,val job:String): Parcelable
```
- #### repeat the same steps as above but when yoy determine the type of argument pick [custom parcelable] as shown 
<img src=https://user-images.githubusercontent.com/59161258/104126382-df1d3380-5364-11eb-9066-17fae92f50b8.png width="600" height="400"/>
 
 - #### It's time to build the project 
 - #### [Sender] Inside The Sending Fragment add the following code 
 
  ```
   btn.setOnClickListener {
    val name = nameEt.text.toString()
    val job = jobEt.text.toString()
    val user = User(name,job)
    val action = Fragment_ADirections.actionFragmentAToFragmentB(user)
    it.findNavController().navigate(action)
   }
  ```  

- #### [Receiver] Inside The Receiving Fragment add the following code
 ```
   val user = args.user
   nameTv.text = user.name
   jobTv.text = user.job
 ```  
        

 
