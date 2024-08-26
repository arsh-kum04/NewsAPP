# News Application

## Overview

This project is a news application that fetches articles from a NEWSAPI.ORG API's and displays them in a user-friendly UI built with Jetpack Compose. Users can view a list of news articles and navigate to detailed views of individual articles. The project leverages several modern Android development technologies to ensure a scalable, maintainable, and efficient codebase.

## Technologies Used

### 1. **Kotlin**
   - ![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?logo=kotlin&logoColor=white&style=flat-square)
   - **Purpose:** The main programming language used for developing the entire Android application.

### 2. **Jetpack Compose**
   - ![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?logo=android&logoColor=white&style=flat-square)
   - **Purpose:** Used for building the UI of the application in a declarative manner.

### 3. **Hilt**
   - ![Hilt](https://img.shields.io/badge/Hilt-D14836?logo=android&logoColor=white&style=flat-square)
   - **Purpose:** Dependency injection framework to manage dependencies and improve code modularity.

### 4. **Room**
   - ![Room](https://img.shields.io/badge/Room-0033A0?logo=android&logoColor=white&style=flat-square)
   - **Purpose:** Provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.

### 5. **Retrofit**
   - ![Retrofit](https://img.shields.io/badge/Retrofit-43B02A?logo=android&logoColor=white&style=flat-square)
   - **Purpose:** Type-safe HTTP client used for interacting with the API to fetch news articles.

### 6. **Coroutines**
   - ![Coroutines](https://img.shields.io/badge/Coroutines-007FFF?logo=android&logoColor=white&style=flat-square)
   - **Purpose:** Asynchronous programming used to perform network operations off the main thread, ensuring a smooth user experience.

### 7. **Navigation Component**
   - ![Navigation](https://img.shields.io/badge/Navigation-5A9?logo=android&logoColor=white&style=flat-square)
   - **Purpose:** Handles in-app navigation, allowing users to move between different screens seamlessly.

## Features

- **Display News Articles:** Fetch and display a list of news articles from a remote API.
- **Detail View:** Navigate to a detailed view of each article with full content.
- **Favorite Articles:** Mark articles as favorites for easy access.
- **Offline Support:** Caching of news articles using Room database for offline access.

## Project Structure

- **`MainActivity.kt`:** Hosts the main UI components and sets up the navigation.
- **`NewsRepository.kt`:** Handles data operations including API calls and database interactions.
- **`NewsViewModel.kt`:** Manages UI-related data in a lifecycle-conscious way, using LiveData and StateFlow.
- **`NewsAPI.kt`:** Defines the API endpoints and methods for Retrofit to fetch data from the network.
- **`NewsDAO.kt`:** Interface for database operations, using Room annotations to define queries.

## Setup and Installation

1. **Clone the repository:**
   git clone https://github.com/your-username/news-app.git
   
2. **Open the project in Android Studio.**
3. **Build the project:**
4. **Run the app on an emulator or connected device.**

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.


