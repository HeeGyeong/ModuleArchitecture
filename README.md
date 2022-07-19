# Modular Architecture Sample

## Description
Clean Architecture에서 조금 더 확장하여 View 단위 별로 Module로 나누어 만들어본 Sample Code 입니다.

Core 모듈은 각 Module에서 공통적으로 사용하는 클래스를 따로 빼내어 관리하기 위하여 만들어두었습니다.

## Architecture 
Clean Architecture를 기반으로 작성하였으며, Coordinator Pattern을 사용하여 화면 단위로 Module이 나뉘어져 있습니다.


각 화면은 모든 화면을 참조하고 있는 Presentation Module을 통해서만 이동하게 되어있으며, Presentation Module은 Initializer를 통해서 다른 화면을 호출하게 됩니다.
즉, 각 Activity Module은 Initializer를 통해서만 접근이 가능하고, 각 Initializer는 Presentation Module에서 접근이 가능합니다.
Initializer에서 전달 받은 Data를 컨트롤하여 Activity에 사용할 수 있도록 하였습니다.


그 외 Data, Domain Module은 Clean Architecture와 동일한 역할을 하도록 구현되어있습니다.

## Gradle
Gradle에서의 공통된 코드르 최소화하고, 관리의 용의성을 높이기 위하여 Gradle을 공통화 하였습니다.

android.gradle에서는 compile, buildTools, targetSdk 등 기본적인 android 설정을 모아두었으며,

그 외 추가로 작성한 gradle 파일은 파일이름을 통해 직관적으로 어떠한 값이 들어있는지 알 수 있도록 하였습니다.

2022.05. Gradle Version 7.2 대응 작업.

2022.05. Build Type, ProductFlavors 추가.

Build Type은 Project 범위의 Gradle을 확인하고,
ProductFlavors는 App 범위의 Module인 Presentation Gradle을 확인하며 알 수 있습니다.

## DI
Koin을 사용하고 있으며, Gradle Version 7.2 사용과 동시에 Koin Version 3.2로 최신화 하였습니다.

## Blog
Modular Architecture에 대한 설명은 다음 블로그에 작성해 두었습니다.

[Tistory Blog](https://heegs.tistory.com/69?category=915533 "Modular Architecture Example")
