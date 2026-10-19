# Task Manager

A modern Android application built with **Jetpack Compose** that displays task status and completion screens.

## 📱 Features

- **Jetpack Compose UI**: Declarative layout using Jetpack Compose (`Column`, `Text`, `Image`, `Surface`).
- **Material 3 Design**: Designed with modern Material Design 3 components and themes.
- **Edge-to-Edge Display**: Supports Android edge-to-edge layout features.
- **Composable Previews**: Includes preview annotations for rapid UI development in Android Studio.

## 🛠️ Tech Stack & Tools

- **Language**: [Kotlin](https://kotlinlang.org/)
- **UI Framework**: [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **Design System**: [Material Design 3](https://m3.material.io/)
- **Build System**: Gradle (Kotlin DSL)
- **Min SDK**: 24 (Android 7.0 Nougat)
- **Target SDK**: 36

## 🚀 Getting Started

### Prerequisites

- [Android Studio](https://developer.android.com/studio) (Ladybug or newer recommended)
- JDK 11 or higher

### Running the App

1. Clone or download this repository:
   ```bash
   git clone <repository-url>
   cd taskmanager
   ```
2. Open the project in **Android Studio**.
3. Allow Gradle to sync dependencies.
4. Select an emulator or physical device and click **Run (Shift + F10)**.

## 📁 Project Structure

```text
taskmanager/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/akshit/taskmanager/
│           │   ├── MainActivity.kt       # Main entry point and UI composables
│           │   └── ui/theme/             # Color, Type, and Theme definitions
│           └── res/                      # Drawables, layouts, and app icons
└── build.gradle.kts                      # Project configurations
```

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
