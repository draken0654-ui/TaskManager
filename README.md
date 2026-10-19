# 📋 Task Manager

<p align="center">
  <img src="app/src/main/res/drawable-mdpi/ic_task_completed.png" alt="Task Manager Logo" width="120"/>
</p>

<p align="center">
  <b>A modern, minimalist Android application built with Jetpack Compose & Material 3</b>
</p>

<p align="center">
  <a href="https://kotlinlang.org"><img src="https://img.shields.io/badge/Language-Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white" alt="Kotlin"></a>
  <a href="https://developer.android.com/jetpack/compose"><img src="https://img.shields.io/badge/UI-Jetpack%20Compose-4285F4?style=for-the-badge&logo=android&logoColor=white" alt="Jetpack Compose"></a>
  <a href="https://m3.material.io"><img src="https://img.shields.io/badge/Design-Material%203-757575?style=for-the-badge&logo=materialdesign&logoColor=white" alt="Material 3"></a>
  <a href="https://developer.android.com/about/versions/15"><img src="https://img.shields.io/badge/Target%20SDK-36-3DDC84?style=for-the-badge&logo=android&logoColor=white" alt="Target SDK 36"></a>
  <a href="LICENSE"><img src="https://img.shields.io/badge/License-MIT-green?style=for-the-badge" alt="License"></a>
</p>

---

## 🌟 Overview

**Task Manager** is an Android application showcasing clean UI design principles using declarative **Jetpack Compose** components. It displays a polished task completion screen with custom graphics, styled typography, and edge-to-edge layout support.

---

## ✨ Features

- 🎨 **Declarative Jetpack Compose UI**: Built using `Column`, `Image`, `Text`, and `Surface` composables.
- 📐 **Centering & Layout Alignment**: Perfectly balanced layout arrangements (`Arrangement.Center`, `Alignment.CenterHorizontally`).
- 📱 **Edge-to-Edge Display**: Utilizes Android's `enableEdgeToEdge()` API for full-screen layout.
- 🎨 **Material 3 Custom Theme**: Configured with `TaskManagerTheme` containing color palettes and typography definitions.
- ⚡ **Live Compose Previews**: Integrated `@Preview` composables for real-time UI design directly inside Android Studio.

---

## 📱 Screen Preview

<p align="center">
  <img src="https://raw.githubusercontent.com/draken0654-ui/TaskManager/main/app/src/main/res/drawable-mdpi/ic_task_completed.png" alt="Task Completed Graphic" width="180"/>
  <br>
  <b>"All tasks completed — Nice work!"</b>
</p>

---

## 🛠 Tech Stack & Architecture

| Component | Technology / Library |
| :--- | :--- |
| **Language** | [Kotlin](https://kotlinlang.org/) |
| **UI Framework** | [Jetpack Compose](https://developer.android.com/jetpack/compose) |
| **Design System** | [Material Design 3](https://m3.material.io/) |
| **Build System** | Gradle with Version Catalogs (`libs.versions.toml`) |
| **Minimum SDK** | API 24 (Android 7.0 Nougat) |
| **Target SDK** | API 36 (Android 15) |

---

## 📁 Project Structure

```text
TaskManager/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/akshit/taskmanager/
│   │   │   │   ├── MainActivity.kt       # Core activity and Compose UI components
│   │   │   │   └── ui/theme/             # Material 3 Design Tokens
│   │   │   │       ├── Color.kt          # Color definitions
│   │   │   │       ├── Theme.kt          # TaskManagerTheme wrapper
│   │   │   │       └── Type.kt           # Typography configurations
│   │   │   └── res/                      # Drawables & application resources
│   │   │       └── drawable-mdpi/        # Task completion icons
│   └── build.gradle.kts                  # Module-level Gradle configuration
├── gradle/
│   └── libs.versions.toml                # Version Catalog for dependencies
├── build.gradle.kts                      # Root Gradle script
└── settings.gradle.kts                   # Project settings
```

---

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed:
- [Android Studio Ladybug (2024.2.1)](https://developer.android.com/studio) or newer
- JDK 11 or higher
- Android SDK (API Level 36)

### Building & Running

1. **Clone the Repository**
   ```bash
   git clone https://github.com/draken0654-ui/TaskManager.git
   cd TaskManager
   ```

2. **Open in Android Studio**
   - Select **File > Open** and choose the `TaskManager` root directory.
   - Allow Gradle to perform the initial sync.

3. **Run on Device / Emulator**
   - Connect an Android device or launch an AVD (Android Virtual Device).
   - Press **Run `app`** (`Shift + F10`).

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!  
Feel free to check out the [issues page](https://github.com/draken0654-ui/TaskManager/issues).

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📜 License

Distributed under the **MIT License**. See `LICENSE` for more information.
