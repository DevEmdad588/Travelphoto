# Travel Photo AppThis is a simple Android app that displays a slideshow of travel photos with their corresponding place names.

## Features

* Displays a slideshow of images.
* Shows the name of the place associated with each image.
* shows location ofo each place on google map.
* Allows users to navigate through the slideshow using "Next" and "Previous" buttons.

## Architecture

* MainActivity: The main activity that handles the slideshow logic and UI updates.
* activity_main.xml: The layout file defining the UI elements (ImageView, TextView, Buttons,location button).
* Drawable resources: Images of travel destinations stored in the `drawable` folder.
* String resources: Place names stored in the `strings.xml` file.
* Google_map: Imlemented google map location services. 

## Libraries Used

* View Binding: For type-safe access to UI elements.
* AndroidX Core: For compatibility and UI utilities.
* AppCompat: For supporting older Android versions.

## Usage

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the app.
4. Use the "Next" and "Previous" buttons to navigate through the slideshow.

## Future Enhancements

* Add more travel photos and place names.
* Implement a timer for automatic slideshow progression.
* Allow users to zoom in/out on images.
* Add a map view to show the location of each place.
* Improve accessibility with content descriptions for images.

## Contributing

Contributions are welcome! Feel free to open issues or pull requests.
