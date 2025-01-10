# MyBookFinderApp

MyBookFinderApp is an Android application that allows users to search for books using the Open Library API. The app displays a list of books based on the user's search query and provides detailed information for each selected book.

## Features

- **Search Books**: Users can search for books by entering a query in the search bar located in the top navigation bar. The app fetches and displays a list of books from the Open Library API matching the search query.

- **View Book Details**: Users can select a book from the list to view detailed information, including the title, author, cover image, and description.

- **Offline Access**: Searched books are cached in a local database, allowing users to access previously viewed books without an internet connection.

## Architecture

The app follows the MVVM (Model-View-ViewModel) architecture pattern, ensuring a clear separation of concerns and facilitating easier testing and maintenance.

### Components

1. **Model**: Represents the data layer of the application.

    - `Book`: A data class representing a book entity stored in the local database.

    - `BookResponse` and `ApiBook`: Data classes representing the API response and individual book data from the Open Library API.

2. **View**: Comprises the UI components built using Jetpack Compose.

    - `BookListScreen`: Displays a list of books based on the search query.

    - `BookDetailScreen`: Shows detailed information about a selected book.

3. **ViewModel**: Manages UI-related data and handles the communication between the Model and the View.

    - `BookViewModel`: Provides data to the UI and handles user interactions.

    - `BookViewModelFactory`: Factory class for creating instances of `BookViewModel`.

4. **Repository**: Acts as a mediator between the ViewModel and the data sources.

    - `BookRepository`: Fetches data from the Open Library API and the local database.

5. **Database**: Manages local data storage using Room.

    - `BookDao`: Data Access Object defining methods to interact with the `Book` table.

    - `BookDatabase`: Abstract class representing the Room database.

6. **Network**: Handles API calls using Retrofit.

    - `BookApiService`: Defines the API endpoints for fetching book data.

    - `RetrofitInstance`: Singleton object providing the Retrofit instance.

7. **Navigation**: Manages navigation between different screens.

    - `Screen`: Sealed class defining the routes for navigation.

## Dependencies

The app utilizes several libraries to enhance functionality:

- **Retrofit**: For making network requests to the Open Library API.

- **Room**: For local database management.

- **Jetpack Compose**: For building the UI.

- **Coil**: For loading images asynchronously.

- **Navigation Component**: For handling navigation between screens.