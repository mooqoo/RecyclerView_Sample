# RecyclerView_Sample

This project explore the basic structure of RecyclerView and demonstrate the ability of LayoutManager. 
In this demo code, you can select different radio button to see the behavior of the different LayoutManager being used.
By click on the item itself, it will display a toast message indicating that the item is pressed.

![app layout](https://cloud.githubusercontent.com/assets/6467567/10116772/d6f66eb6-6471-11e5-967a-ce9107089ca7.png)

This Sample Code includes:

 -   add `compile 'com.android.support:recyclerview-v7:21.0.0'` in **build.gradle** for backward compatibility 
 -   create custom **data** for RecyclerView
 -   setup **adapter** to draw the view with the data
 -   explore different **LayoutManager**'s behavior
 -   implement **onClickListener** inside **adapter's ViewHolder**
 

LayoutManager
=============
There are three types of LayoutManager:

 -   **LinearLayoutManager**: it shows items in a vertical or horizontal scrolling list
 -   **GridLayoutManager**: it shows items in a grid
 -   **StaggeredGridLayoutManager**: it shows items in a grid
 
In addition to that, to create a custom layout manager, extend the RecyclerView.LayoutManager class.




