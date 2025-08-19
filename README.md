# 여행/여정 기록 서비스 - 프로디지털아카데미 6기 백엔드 미니프로젝트
## 서비스 기획 의도
이 프로젝트는 신한투자증권 프로디지털아카데미 6기 과정에서 진행된 자바 기반 백엔드 미니프로젝트입니다.
자바를 공부하기 위한 프로젝트입니다.

## 👋 introduce team member
| 이름                                        |
| -------------------------------------------- | 
| [여은동](https://github.com/sillonjeu)       | 
| [곽예경](https://github.com/kyun9-cloud) | 
| [조정현](https://github.com/CISXO) | 
| [황인찬](https://github.com/klklgooa) | 

---

# 🛠️ Tech
## Backend
![Express](https://img.shields.io/badge/Express.js-000000?style=for-the-badge&logo=express&logoColor=white)

---
# Project Introduction
## Architecture - 클래스 다이어그램
<img width="954" height="498" alt="image" src="https://github.com/user-attachments/assets/3313fd57-38b2-4858-a861-c6d142652ae4" />

---
## 폴더 구조
```
backendMiniProject
├── .gradle
├── .idea
├── build
├── gradle
├── out
├── src
│   └── main
│       ├── java
│       │   └── org.example
│       │       ├── domain
│       │       │   ├── itinerary
│       │       │   │   ├── controller
│       │       │   │   │   └── ItineraryController
│       │       │   │   ├── entity
│       │       │   │   │   └── Itinerary
│       │       │   │   ├── repository
│       │       │   │   │   └── ItineraryRepository
│       │       │   │   └── service
│       │       │   │       └── ItineraryService
│       │       │   ├── orchestration
│       │       │   │   └── controller
│       │       │   │       └── OrchestrationController
│       │       │   └── trip
│       │       │       ├── controller
│       │       │       │   └── TripController
│       │       │       ├── entity
│       │       │       │   └── Trip
│       │       │       ├── repository
│       │       │       │   └── TripRepository
│       │       │       └── service
│       │       │           └── TripService
│       │       ├── globals
│       │       │   ├── exceptions
│       │       │   │   ├── ErrorMessage
│       │       │   │   ├── FileLoadException
│       │       │   │   ├── InputException
│       │       │   │   └── InvalidItineraryTimeException
│       │       │   └── utils
│       │       │       ├── FileNo
│       │       │       ├── InputValidator
│       │       │       └── TimeValidator
│       │       └── view
│       │           ├── inputView
│       │           │   └── InputView
│       │           └── outputView
│       │               ├── OutputView
│       │               └── OutputViewMessage
│       └── Main
│           └── resources
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
└── settings.gradle
```
---
## ✨ Screen
| Title         | Img                                   |      
| ------------ | ---------------------------------------- | 
| 여행 기록    | <img width="1128" height="1452" alt="image" src="https://github.com/user-attachments/assets/768d9d71-a742-4637-ad44-9a79f21c8335" />| 
| 여정 기록    | <img width="1104" height="1230" alt="image" src="https://github.com/user-attachments/assets/aeb3ac30-f961-4659-9544-225d9ffbdfd6" />| 
| 여행 및 여정 조회   | <img width="674" height="1338" alt="image" src="https://github.com/user-attachments/assets/035c351f-e045-4eaa-a7b2-571c1ef69f6c" />| 

---



## 🎯 Commit Convention

- feat: Add a new feature
- fix: Bug fix
- docs: Documentation updates
- style: Code formatting, missing semicolons, cases where no code change is involved
- refactor: Code refactoring
- test: Test code, adding refactoring tests
- hore: Build task updates, package manager updates

## 💡 PR Convetion

| 아이콘 | 코드                       | 설명                     |
| ------ | -------------------------- | ------------------------ |
| 🎨     | :art                       | Improving structure/format of the code   |
| ⚡️    | :zap                       | Performance improvement               |
| 🔥     | :fire                      | 	Code/file deletion          |
| 🐛     | :bug                       | Bug fix             |
| 🚑     | :ambulance                 | Critical fix|
| ✨     | :sparkles                  | New features               |
| 💄     | :lipstick                  | Adding/updating UI/style files |
| ⏪     | :rewind                    | Reverting changes     |
| 🔀     | :twisted_rightwards_arrows | Branch merging            |
| 💡     | :bulb                      | Adding/updating comments         |
| 🗃      | :card_file_box             | Database-related modifications   |
